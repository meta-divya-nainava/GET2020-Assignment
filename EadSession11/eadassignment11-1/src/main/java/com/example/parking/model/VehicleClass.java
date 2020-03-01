package com.example.parking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name="vehicledata")
public class VehicleClass {
	@Id
	@Column(name = "emp_id")
	private int empId;
	@NotBlank
	@Pattern(regexp="^[a-zA-Z0-9]{1,}\\s{0,}[a-zA-Z0-9]{0,}$",message = "Please enter valid name")
	@Column(name = "vehicle_Name")
	private String vehicleName;
	@NotBlank
	@Size(min = 4, max =  4, message = "please enter valid vehiclenumber")
	@Column(name = "vehicle_Number")
	private String vehicleNumber;
	@Override
	public String toString() {
		return "VehicleClass [empId=" + empId + ", vehicleName=" + vehicleName + ", vehicleNumber=" + vehicleNumber
				+ ", vehicleType=" + vehicleType + ", identification=" + identification + ", plan=" + plan + ", price="
				+ price + ", getEmpId()=" + getEmpId() + ", getVehicleName()=" + getVehicleName()
				+ ", getVehicleNumber()=" + getVehicleNumber() + ", getVehicleType()=" + getVehicleType()
				+ ", getIdentification()=" + getIdentification() + ", getPlan()=" + getPlan() + ", getPrice()="
				+ getPrice() + "]";
	}
	@Column(name = "vehicle_Type")
	private String vehicleType;
	@NotBlank
	@Column(name = "identification")
	private String identification;
	@Column(name = "plan")
	private String plan;
	@Column(name = "price")
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
