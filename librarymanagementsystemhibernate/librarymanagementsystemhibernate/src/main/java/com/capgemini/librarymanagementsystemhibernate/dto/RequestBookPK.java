package com.capgemini.librarymanagementsystemhibernate.dto;

import java.io.Serializable;
//import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RequestBookPK implements Serializable{
	//@Column(insertable = false,updatable = false)
private int bid;
	//@Column(insertable = false,updatable = false)
private String email;
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "RequestBookPK [bid=" + bid + ", email=" + email + "]";
}
}
