package com.example.parking.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FriendClass {
	private int empId;
	@NotBlank
	@Pattern(regexp="^[a-zA-Z]{1,}\\s{1}[a-zA-Z]{1,}$",message = "Please enter valid name")
	private String name;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
