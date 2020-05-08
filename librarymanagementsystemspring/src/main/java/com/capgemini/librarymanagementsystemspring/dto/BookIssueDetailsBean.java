package com.capgemini.librarymanagementsystemspring.dto;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Entity
@Table(name = "bookissuespring")
public class BookIssueDetailsBean {
	@Id
	private BookIssueDetailsPK issuePK;
	@Column
	private int id;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "issueDate")
	private java.util.Date Date = new java.util.Date();
	@Column
	private Date returnDate;
	
	
	
	  @Exclude 
	  // @MapsId
	  
	  @ManyToOne(cascade=CascadeType.ALL)
	  
	  @JoinColumn(name="email" , insertable = false,updatable = false)
	  private UserBean primary;



	public BookIssueDetailsPK getIssuePK() {
		return issuePK;
	}



	public void setIssuePK(BookIssueDetailsPK issuePK) {
		this.issuePK = issuePK;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public java.util.Date getDate() {
		return Date;
	}



	public void setDate(java.util.Date date) {
		Date = date;
	}



	public Date getReturnDate() {
		return returnDate;
	}



	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}



	public UserBean getPrimary() {
		return primary;
	}



	public void setPrimary(UserBean primary) {
		this.primary = primary;
	}
	  
	  
	 
}
