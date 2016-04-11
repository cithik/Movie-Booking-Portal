package com.me.moviebooking.model;

public class BookingRating {
	Integer bookingId;
	Integer movieRating;
	Integer screenRating;
	String screenComment;
	String movieComment;
	public BookingRating(){
		super();
	}
	public BookingRating(Integer bookingId, Integer movieRating,
			Integer screenRating, String screenComment, String movieComment) {
		super();
		this.bookingId = bookingId;
		this.movieRating = movieRating;
		this.screenRating = screenRating;
		this.screenComment = screenComment;
		this.movieComment = movieComment;
	}
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(Integer movieRating) {
		this.movieRating = movieRating;
	}
	public Integer getScreenRating() {
		return screenRating;
	}
	public void setScreenRating(Integer screenRating) {
		this.screenRating = screenRating;
	}
	public String getScreenComment() {
		return screenComment;
	}
	public void setScreenComment(String screenComment) {
		this.screenComment = screenComment;
	}
	public String getMovieComment() {
		return movieComment;
	}
	public void setMovieComment(String movieComment) {
		this.movieComment = movieComment;
	}
}
