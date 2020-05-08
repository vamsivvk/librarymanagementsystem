package com.capgemini.librarymanagementsystemspring.dto;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.bytebuddy.build.ToStringPlugin.Exclude;


@Entity
@Table(name="requestbookspring")
//@IdClass(RequestBookPK.class)
public class RequestBookBean {
	@EmbeddedId
	private RequestBookPK reqBookPK;
	
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String book_title;

	@Column
	private String type;



	@Exclude 
	// @MapsId

	@ManyToOne(cascade=CascadeType.ALL)

	@JoinColumn(name="email" , insertable = false ,updatable = false) 
	private UserBean primary;



	public RequestBookPK getReqBookPK() {
		return reqBookPK;
	}



	public void setReqBookPK(RequestBookPK reqBookPK) {
		this.reqBookPK = reqBookPK;
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



	public String getBook_title() {
		return book_title;
	}



	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public UserBean getPrimary() {
		return primary;
	}



	public void setPrimary(UserBean primary) {
		this.primary = primary;
	}
}
