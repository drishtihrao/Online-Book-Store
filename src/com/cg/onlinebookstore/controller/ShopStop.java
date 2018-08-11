package com.cg.onlinebookstore.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.onlinebookstore.dao.StoreDAO;
import com.cg.onlinebookstore.dao.StoreDAOImpl;
import com.cg.onlinebookstore.pojo.Book;
import com.cg.onlinebookstore.service.StoreService;
import com.cg.onlinebookstore.service.StoreServiceImpl;

@WebServlet("*.app")
public class ShopStop extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreService service = new StoreServiceImpl();
	StoreDAO dao = new StoreDAOImpl();


	public ShopStop() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		HttpSession session = request.getSession();
		session.setAttribute("cartItems", service.displayCartList());
		session.setAttribute("cartCount", service.getCartCount());
		System.out.println(action);

		switch (action) {
		case "/refresh.app":
			dao.homePageList();

			Collection<Book> book = service.displayAllBooks();
			book.stream().forEach(System.out::println);
			request.setAttribute("book", book);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			break;

		case "/addtocart.app":
			String bookName = request.getParameter("bookName");
			String authorName = request.getParameter("authorName");
			String description = request.getParameter("description");
			int price = Integer.parseInt(request.getParameter("price"));
			int bookCount = Integer.parseInt(request.getParameter("bookCount"));
			String bookImg = request.getParameter("bookImg");

			Book addedBook = new Book(bookName, authorName, description, price, bookCount, bookImg);

			service.addToCart(addedBook);
			response.sendRedirect("viewAll.app");
			break;

		case "/viewAll.app":

			Collection<Book> addedBooks = service.displayCartList();
			addedBooks.stream().forEach(System.out::println);
			request.setAttribute("addedBooks", addedBooks);
			dispatcher = request.getRequestDispatcher("addtocart.jsp");
			dispatcher.forward(request, response);
			break;

		case "/delete.app":
			bookName = request.getParameter("bookName");
			authorName = request.getParameter("authorName");
			description = request.getParameter("description");
			price = Integer.parseInt(request.getParameter("price"));
			bookCount = Integer.parseInt(request.getParameter("bookCount"));
			bookImg = request.getParameter("bookImg");

			Book deletedBook = new Book(bookName, authorName, description, price, bookCount, bookImg);

			System.out.println(deletedBook);

			service.deleteFromCart(deletedBook);

			response.sendRedirect("viewAll.app");
			break;

		case "/viewcart.app":
			response.sendRedirect("viewAll.app");
			break;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
