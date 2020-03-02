package com.example.parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserClass {
	@NotEmpty
	@Email(message = "Please enter valid email")
	private  String userEmail;
	
	@NotEmpty
	@Size(min = 8, max =  50, message = "please enter strong password length.length should be between 8 -50")
	private String password;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
