package com.me.moviebooking.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserPreferences {
	@NotEmpty @NotNull
	private Integer cinemaId;
	@NotEmpty @NotNull
	private Integer movieId;
	@NotEmpty @NotNull
	private Integer screenId;
//	@DateTimeFormat(pattern="MM/dd/yyyy")
//    @NotNull @Future
//	private Date reqDate;
	@NotNull @NotEmpty
	private String time;
	
	public UserPreferences(){
		super();
	}
	
	public UserPreferences(Integer cinemaId, Integer movieId, Integer screenId,
			String time) {
		super();
		this.cinemaId = cinemaId;
		this.movieId = movieId;
		this.screenId = screenId;
		this.time = time;
	}
	
	public Integer getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
