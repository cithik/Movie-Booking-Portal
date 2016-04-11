package com.me.moviebooking.model;

import java.io.Serializable;

public class Screen implements Serializable{
	int screenId;
	String name;
	Movie movie;
	int seatsAvailable;
	int seatsBooked;
	Cinema cinema;
	
	public Screen() {
		super();
	}
	public Screen(int screenId, String name, Movie movie, int seatsAvailable,
			int seatsBooked, Cinema cinema) {
		super();
		this.screenId = screenId;
		this.name = name;
		this.movie = movie;
		this.seatsAvailable = seatsAvailable;
		this.seatsBooked = seatsBooked;
		this.cinema = cinema;
	}
	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}	
	public String toString(){
		return this.getName();
	}
}
