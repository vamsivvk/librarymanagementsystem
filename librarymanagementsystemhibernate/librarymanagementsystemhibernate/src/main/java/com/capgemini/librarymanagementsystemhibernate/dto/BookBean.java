package com.capgemini.librarymanagementsystemhibernate.dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookdetails")
public class BookBean {
	@Id
	@Column(unique=true, updatable = false)
	private int bid;
	@Column
	private String book_title;
	@Column(updatable = false)
	private String category;
	@Column(updatable = false)
	private String author;
	@Column(updatable = false)
	private String book_publisher;
	@Column(updatable = false)
	private String publisher_name;
	@Column(updatable = false)
	private int copies;
	@Column(updatable = false)
	private int ISBN;
	@Column(updatable = false)
	private int copyright_year;
	@Column(updatable = false)
	private String status;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getCopyright_year() {
		return copyright_year;
	}
	public void setCopyright_year(int copyright_year) {
		this.copyright_year = copyright_year;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}









