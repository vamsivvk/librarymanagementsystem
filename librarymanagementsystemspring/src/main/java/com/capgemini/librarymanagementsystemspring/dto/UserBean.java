package com.capgemini.librarymanagementsystemspring.dto;

import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="userspring")
public class UserBean {
	@Id
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private int id;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private long mobile;
	@Column
	private String role;
	
	  public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<RequestBookBean> getReqBook() {
		return reqBook;
	}

	public void setReqBook(List<RequestBookBean> reqBook) {
		this.reqBook = reqBook;
	}

	public List<BookIssueDetailsBean> getBookIssue() {
		return bookIssue;
	}

	public void setBookIssue(List<BookIssueDetailsBean> bookIssue) {
		this.bookIssue = bookIssue;
	}

	public List<BorrowedBookBean> getBorrowBook() {
		return borrowBook;
	}

	public void setBorrowBook(List<BorrowedBookBean> borrowBook) {
		this.borrowBook = borrowBook;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="primary",fetch = FetchType.EAGER) 
	  private List<RequestBookBean> reqBook;
	  
	  @OneToMany(cascade=CascadeType.ALL,mappedBy="primary") private
	  List<BookIssueDetailsBean> bookIssue;
	 
	@OneToMany(cascade=CascadeType.ALL,mappedBy="primary")
	private List<BorrowedBookBean> borrowBook;
		
}
