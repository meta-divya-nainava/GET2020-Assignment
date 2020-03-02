package com.example.parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeClass {
	@NotBlank
	@Pattern(regexp="^[a-zA-Z]{1,}\\s{1}[a-zA-Z]{1,}$",message = "Please enter valid name")
	private String name;
	@NotBlank
	@Email(message ="please enter valid email")
	private String email;
	@NotBlank
	//@Size(min = 10, max =  10, message = "please enter valid phone number")
	@Pattern(regexp="^[0-9]{10}$",message = "Please enter valid phone number")
	private String contact;
	@NotBlank
	@Size(min = 8, max =  50, message = "please enter strong password length.length should be between 8 -50")
	private String password;
	@NotBlank
	private String gender;
	private String typeOfOrg;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTypeOfOrg() {
		return typeOfOrg;
	}
	public void setTypeOfOrg(String typeOfOrg) {
		this.typeOfOrg = typeOfOrg;
	}

}
