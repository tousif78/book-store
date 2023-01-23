package com.js.dto;

public class Book {
	private int Book_ID;
	private String book_Name;
	private String Author_Name;
    private int NumberOfPages;
    private double Price;
	public int getBook_ID() {
		return Book_ID;
	}
	public void setBook_ID(int book_ID) {
		Book_ID = book_ID;
	}
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public String getAuthor_Name() {
		return Author_Name;
	}
	public void setAuthor_Name(String author_Name) {
		Author_Name = author_Name;
	}
	public int getNumberOfPages() {
		return NumberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		NumberOfPages = numberOfPages;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
	public String toString() {
		return "Book [Book_ID=" + Book_ID + ", book_Name=" + book_Name + ", Author_Name=" + Author_Name
				+ ", NumberOfPages=" + NumberOfPages + ", Price=" + Price + "]";
	}
	
    
}
