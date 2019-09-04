package com.Boardimak.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Buyer {

	@Id
	private int userID;
	private String first_name;
	private String Last_name;
	private String email;
	private String password;
	private String stripeID;
	private String type;
	
	public Buyer() {
		
	}
	
	
	public String getFirst_name() {
		return first_name;
	}
	
	public int getId() {
		return this.userID;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStripeID() {
		return stripeID;
	}
	public void setStripeID(String stripeID) {
		this.stripeID = stripeID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Buyer(int userID, String first_name, String last_name, String email, String password, String stripeID, String type) {
		super();
		this.userID = userID;
		this.first_name = first_name;
		Last_name = last_name;
		this.email = email;
		this.password = password;
		this.stripeID = stripeID;
		this.type = type;
	}
	

}
