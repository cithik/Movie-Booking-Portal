package com.me.moviebooking.model;

import java.io.Serializable;

public class Cinema implements Serializable{

	int cinemaId;
	String name;
	String Address;
	String Phone;
	String email;
	
	public Cinema() {
		super();
	}
	
	public Cinema(int cinemaId, String name, String address, String phone,
			String email) {
		super();
		this.cinemaId = cinemaId;
		this.name = name;
		Address = address;
		Phone = phone;
		this.email = email;
	}
	
	public int getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String toString(){
		return this.getName();
	}
}
