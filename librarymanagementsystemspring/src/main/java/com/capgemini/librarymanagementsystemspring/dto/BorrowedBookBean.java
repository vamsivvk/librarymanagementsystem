package com.capgemini.librarymanagementsystemspring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.bytebuddy.build.ToStringPlugin.Exclude;


@Entity
@Table(name="borrowbookspring")
public class BorrowedBookBean {
	@Id
	private BorrowedBookBeanPK borrowBookPK;
	@Column
	private int id;
//	@Column(insertable = false,updatable = false)
//	private int bid;
//	@Column(insertable = false,updatable = false)
//	private String email;
//	

	
	  @Exclude //@MapsId
	  
	  @ManyToOne
	  
	  @JoinColumn(name="email" , insertable = false,updatable = false) 
	  private UserBean primary;


	public BorrowedBookBeanPK getBorrowBookPK() {
		return borrowBookPK;
	}


	public void setBorrowBookPK(BorrowedBookBeanPK borrowBookPK) {
		this.borrowBookPK = borrowBookPK;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public UserBean getPrimary() {
		return primary;
	}


	public void setPrimary(UserBean primary) {
		this.primary = primary;
	}
	 
	  
}
