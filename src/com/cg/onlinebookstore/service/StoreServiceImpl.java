package com.cg.onlinebookstore.service;

import java.util.Collection;

import com.cg.onlinebookstore.dao.StoreDAO;
import com.cg.onlinebookstore.dao.StoreDAOImpl;
import com.cg.onlinebookstore.pojo.Book;

public class StoreServiceImpl implements StoreService {
	StoreDAO dao = new StoreDAOImpl();

	@Override
	public Collection<Book> displayAllBooks() {
		return dao.displayAllBooks();
	}

	@Override
	public void addToCart(Book book) {
		dao.addToCart(book);
	}

	@Override
	public Collection<Book> displayCartList() {
		return dao.displayCartList();
	}

	@Override
	public void deleteFromCart(Book book) {
		dao.deleteFromCart(book);
	}

	@Override
	public int getCartCount() {
		return dao.getCartCount();
	}
}
