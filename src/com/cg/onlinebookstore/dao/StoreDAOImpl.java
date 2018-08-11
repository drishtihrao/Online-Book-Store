package com.cg.onlinebookstore.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.cg.onlinebookstore.pojo.Book;

public class StoreDAOImpl implements StoreDAO {
	Book book = new Book();
	int cartCount = 0;
	static Map<String, Book> cartList = new HashMap<>();
	static Map<String, Book> bookList = new HashMap<>();

	@Override
	public void homePageList() {
		Book alchemist = new Book("The Alchemist", "Paulo Coleho", "The Alchemist follows a young Andalusian shepherd in his journey to the pyramids of Egypt, after having a recurring dream of finding a treasure there.", 700, 0, "alchemist.jpg");
		Book fountainhead = new Book("The Fountainhead", "Ayn Rand", " The novel's protagonist, Howard Roark, is an individualistic young architect who designs modernist buildings and refuses to compromise with an architectural establishment unwilling to accept innovation.", 500, 0, "fountainhead.jpg");
		Book growrich = new Book("Think and Grow Rich", "Napoleon Hill", "Think and Grow Rich examines the psychological power of thought and the brain in the process of furthering your career for both monetary and personal satisfaction. ", 150, 0,"growrich.jpg");
		Book richdad = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", "Rich Dad Poor Dad advocates the importance of financial literacy, financial independence and building wealth through investing in assets, owning businesses, as well as increasing one's financial intelligence to improve one's business and financial aptitude. ", 650, 0, "richdad.jpg");
		Book secret = new Book("The Secret", "Rhonda Byrne", "The Secret is based on the law of attraction, which claims that thoughts can change the world directly.", 1700, 0, "secret.jpg");

		bookList.put(alchemist.getBookName(), alchemist);
		bookList.put(fountainhead.getBookName(), fountainhead);
		bookList.put(growrich.getBookName(), growrich);
		bookList.put(richdad.getBookName(), richdad);
		bookList.put(secret.getBookName(), secret);

	}

	@Override
	public Collection<Book> displayAllBooks() {
		return bookList.values();
	}

	public void addToCart(Book book) {
		++cartCount;
		System.out.println("cart count is" + cartCount);
		boolean flag = true;
		for (Book books : cartList.values()) {

			if (books.getBookName().equals(book.getBookName())) {
				System.out.println("***********");
				System.out.println(books);
				books.setBookCount(books.getBookCount() + 1);
				flag = false;
				break;
			}
		}

		if (flag) {
			book.setBookCount(1);
			cartList.put(book.getBookName(), book);
		}
	}

	public void deleteFromCart(Book book) {
		cartCount--;
		for (Book books : cartList.values()) {
			if (books.getBookName().equals(book.getBookName())) {
				if (books.getBookCount() == 1) {
					cartList.remove(book.getBookName());
				}
				if (books.getBookCount() > 1) {
					books.setBookCount(books.getBookCount() - 1);
				}

				break;
			}
		}
	}

	public int getCartCount() {
		return cartCount;
	}

	public Collection<Book> displayCartList() {
		return cartList.values();
	}

}
