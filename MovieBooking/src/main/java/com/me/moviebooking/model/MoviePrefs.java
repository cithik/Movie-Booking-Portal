package com.me.moviebooking.model;

import java.util.List;

public class MoviePrefs {
	private String userName;
	private List<Showtime> showtimes;
	private UserPreferences up;
	
	public MoviePrefs(){
		super();
	}
	
	public MoviePrefs(String userName, List<Showtime> showtimes,
			UserPreferences up) {
		super();
		this.userName = userName;
		this.showtimes = showtimes;
		this.up = up;
	}	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
}
