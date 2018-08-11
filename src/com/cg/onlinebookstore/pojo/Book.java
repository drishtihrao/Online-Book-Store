package com.cg.onlinebookstore.pojo;

public class Book {
	private String bookName, authorName, description;
	private int price;
	private int bookCount;
	private String bookImg;

	public Book() {
	}

	public Book(String bookName, String authorName, String description, int price, int bookCount, String bookImg) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.price = price;
		this.bookCount = bookCount;
		this.bookImg = bookImg;
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookCount=" + bookCount + ", bookName=" + bookName + ", authorName=" + authorName
				+ ", description=" + description + ", price=" + price + ", bookImg=" + bookImg + "]";
	}

}
