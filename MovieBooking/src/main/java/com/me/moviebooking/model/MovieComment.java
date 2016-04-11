package com.me.moviebooking.model;

import java.io.Serializable;

public class MovieComment implements Serializable{
	Integer bookingId;
	BookingHistory bookingHistory;
	Integer rating;
	String comment;
	
	public MovieComment(){
		super();
	}
	
	public MovieComment(Integer bookingId, BookingHistory bookingHistory,
			Integer rating, String comment) {
		super();
		this.bookingId = bookingId;
		this.bookingHistory = bookingHistory;
		this.rating = rating;
		this.comment = comment;
	}
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer movieCommentId) {
		this.bookingId = movieCommentId;
	}
	public BookingHistory getBookingHistory() {
		return bookingHistory;
	}
	public void setBookingHistory(BookingHistory bookingHistory) {
		this.bookingHistory = bookingHistory;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
