package com.capgemini.librarymanagementsystemspring.dto;

import java.util.List;

public class lmsResponse {
	private boolean error;
	private String message;
	private UserBean user;
	private List<UserBean> userBean;
	private BookBean book;
	private List<Integer> bookBeanId;
	private List<BookBean> bookBeanList;
	private BookIssueDetailsBean bookIssue;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public List<UserBean> getUserBean() {
		return userBean;
	}
	public void setUserBean(List<UserBean> userBean) {
		this.userBean = userBean;
	}
	public BookBean getBook() {
		return book;
	}
	public void setBook(BookBean book) {
		this.book = book;
	}
	public List<Integer> getBookBeanId() {
		return bookBeanId;
	}
	public void setBookBeanId(List<Integer> bookBeanId) {
		this.bookBeanId = bookBeanId;
	}
	public List<BookBean> getBookBeanList() {
		return bookBeanList;
	}
	public void setBookBeanList(List<BookBean> bookBeanList) {
		this.bookBeanList = bookBeanList;
	}
	public BookIssueDetailsBean getBookIssue() {
		return bookIssue;
	}
	public void setBookIssue(BookIssueDetailsBean bookIssue) {
		this.bookIssue = bookIssue;
	}
}
