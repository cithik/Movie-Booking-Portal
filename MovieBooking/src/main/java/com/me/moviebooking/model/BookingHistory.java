package com.me.moviebooking.model;

import java.io.Serializable;

public class BookingHistory implements Serializable{
	
	Integer bookingId;
	Showtime showtime;
	Customer customer;
	Integer quantity;
	
	public BookingHistory() {
		super();
	}
	
	public BookingHistory(Integer bookingId, Showtime showtime, Customer customer,
			Integer quantity) {
		super();
		this.bookingId = bookingId;
		this.showtime = showtime;
		this.customer = customer;
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
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
}
