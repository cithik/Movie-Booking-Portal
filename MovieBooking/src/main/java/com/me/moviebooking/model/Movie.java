package com.me.moviebooking.model;

import java.io.Serializable;

public class Movie implements Serializable{
	int movieId;
	String name;
	String cast;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(int movieId, String name, String cast) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.cast = cast;
	}
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String toString(){
		return this.getName();
	}
}
