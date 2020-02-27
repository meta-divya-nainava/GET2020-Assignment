package com.example.parking.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class VehicleClass {
	private int empId;
	@NotBlank
	@Pattern(regexp="^[a-zA-Z0-9]{1,}\\s{0,}[a-zA-Z0-9]{0,}$",message = "Please enter valid name")
	private String vehicleName;
	@NotBlank
	@Size(min = 4, max =  4, message = "please enter valid vehiclenumber")
	private String vehicleNumber;
	private String vehicleType;
	@NotBlank
	private String identification;
	private String plan;
	private int price;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
