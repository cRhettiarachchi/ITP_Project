package com.Boardimak.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payments {

	@Id
	private int payment_id;
	private long amount;
	private String status;
	private int property_id;
	private String payment_method;
	private String payment_token;
	
	public Payments(long amount, String status, int property_id, String payment_method,
			String payment_token) {
		super();
		this.amount = amount;
		this.status = status;
		this.property_id = property_id;
		this.payment_method = payment_method;
		this.payment_token = payment_token;
	}

	
	public Payments() {
	}
	
	public int getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


	public long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getProperty_id() {
		return property_id;
	}
	
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	
	public String getPaymentMethod() {
		return payment_method;
	}
	
	public void setPaymentMethod(String date) {
		this.payment_method = date;
	}
	
	public String getPayment_token() {
		return payment_token;
	}
	
	public void setPayment_token(String payment_token) {
		this.payment_token = payment_token;
	}
	
}
