package com.me.moviebooking.model;

import java.util.List;

public class CustomerMoviePrefs {
	private Customer customer;
	private List<Cinema> cinemas;
	private List<Movie> movies;
	private List<Showtime> showtimes;
	private UserPreferences up;
	
	public CustomerMoviePrefs(){
		super();
	}
	
	public CustomerMoviePrefs(Customer customer, List<Cinema> cinemas,
			List<Movie> movies, List<Showtime> showtimes,
			UserPreferences up) {
		super();
		this.customer = customer;
		this.cinemas = cinemas;
		this.movies = movies;
		this.showtimes = showtimes;
		this.up = up;
	}	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public UserPreferences getUp() {
		return up;
	}
	public void setUp(UserPreferences up) {
		this.up = up;
	}
	
	public List<Showtime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}
	public List<Cinema> getCinemas() {
		return cinemas;
	}
	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
}
