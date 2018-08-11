package com.cg.onlinebookstore.service;

import java.util.Collection;

import com.cg.onlinebookstore.pojo.Book;

public interface StoreService {

	Collection<Book> displayAllBooks();

	void addToCart(Book book);

	Collection<Book> displayCartList();

	void deleteFromCart(Book book);

	int getCartCount();

}