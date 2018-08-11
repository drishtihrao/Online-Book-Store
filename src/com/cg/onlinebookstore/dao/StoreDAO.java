package com.cg.onlinebookstore.dao;

import java.util.Collection;

import com.cg.onlinebookstore.pojo.Book;

public interface StoreDAO {

	void homePageList();
	void addToCart(Book book);
	void deleteFromCart(Book book);
	int getCartCount();
	Collection<Book> displayAllBooks();
	Collection<Book> displayCartList();
}