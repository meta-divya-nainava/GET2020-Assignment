package com.example.student.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern; 
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class StudentClass {
	
	
	@NotBlank
	@Pattern(regexp="^[a-zA-Z]{1,}$",message = "Please enter valid name")
	private String firstName;
	
	@NotBlank
	@Pattern(regexp="^[a-zA-Z]{1,}$",message = "Please enter valid name")
	private String lastName;
	
	@NotBlank
	@Pattern(regexp="^[a-zA-Z]{1,}\\s{1}[a-zA-Z]{1,}$",message = "Please enter valid name")
	private String fatherName;
	
	@NotBlank
	@Email(message = "{badEmail}")
	private String email;
	
	private Integer id;
	
	@NotNull
	@Min(value = 1,message = "min value should be 1")
	@Max(value = 12, message = "max value should be 12")
	
	private Integer std;
	
	@NotNull
	@Min(value = 1,message = "min value should be 1")
	@Max(value = 100, message = "max value should be 12")
	
	private Integer age;//issue
	/**
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 
	 * @return fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * 
	 * @param fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return std
	 */
	public Integer getStd() {
		return std;
	}
	/**
	 * 
	 * @param std
	 */
	public void setStd(Integer std) {
		this.std = std;
	}
	/**
	 * 
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	

}
