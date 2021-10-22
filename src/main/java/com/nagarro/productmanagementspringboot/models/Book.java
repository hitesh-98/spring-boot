package com.nagarro.productmanagementspringboot.models;

public class Book {

	private int bookCode;
	private String bookName;
	private String author;
	private String dateAdded;

	public Book() {
		super();
	}

	public Book(int bookCode, String bookName, String author, String dateAdded) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.dateAdded = dateAdded;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookName=" + bookName + ", author=" + author + ", dateAdded="
				+ dateAdded + "]";
	}
}
