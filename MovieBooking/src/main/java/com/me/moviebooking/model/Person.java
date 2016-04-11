package com.me.moviebooking.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.me.moviebooking.validator.Phone;

public class Person {
	@NotEmpty @Size(min=2, max=30) 
	private String firstName;
	@NotEmpty @Size(min=2, max=30) 
	private String lastName;
	@NotEmpty @Email
	private String email;
	@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
	private Date dob;
	@Phone
	private String phone;
	private Integer personId;
	
	public Person(){
		super();
	}
	
	public Person(String firstName, String lastName, String email, Date dob,
			String phone, Integer personId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.personId = personId;
	}
		
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer person_id) {
		this.personId = person_id;
	}
	
}
