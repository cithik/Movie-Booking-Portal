package com.me.moviebooking.model;

import java.io.Serializable;

public class BookingSelection implements Serializable{
	Customer customer;
	Showtime showtime;
	Integer quantity;
	Integer amount;
	
	public BookingSelection(){
		super();
	}
	
	public BookingSelection(Customer customer, Showtime showtime,
			Integer quantity, Integer amount) {
		super();
		this.customer = customer;
		this.showtime = showtime;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Showtime getShowtime() {
		return showtime;
	}
	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}	
}
