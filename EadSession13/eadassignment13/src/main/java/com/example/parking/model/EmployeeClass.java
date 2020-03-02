package com.example.parking.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Columns;
@Entity
@Table(name="employee")
public class EmployeeClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int empId;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@NotBlank
	@Pattern(regexp="^[a-zA-Z]{1,}\\s{1}[a-zA-Z]{1,}$",message = "Please enter valid name")
	@Column(name = "name")
	private String name;
	@NotBlank
	@Email(message ="please enter valid email")
	@Column(name = "email")
	private String email;
	@NotBlank
	//@Size(min = 10, max =  10, message = "please enter valid phone number")
	@Pattern(regexp="^[0-9]{10}$",message = "Please enter valid phone number")
	@Column(name = "contact_no")
	private String contact;
	@NotBlank
	@Size(min = 8, max =  50, message = "please enter strong password length.length should be between 8 -50")
	@Column(name = "password")
	private String password;
	@NotBlank
	@Column(name = "gender")
	private String gender;
	@Column(name="org")
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
