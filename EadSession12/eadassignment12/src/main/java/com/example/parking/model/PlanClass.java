package com.example.parking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="planData")
public class PlanClass {
	@Override
	public String toString() {
		return "PlanClass [vehicleType=" + vehicleType + ", dailyPrice=" + dailyPrice + ", monthlyPrice=" + monthlyPrice
				+ ", yearlyPrice=" + yearlyPrice + "]";
	}
	@Id
	@Column(name = "vehicle_Type")
	private String vehicleType;
	@Column(name = "daily_price")
	private String dailyPrice;
	@Column(name = "monthly_price")
	private String monthlyPrice;
	@Column(name = "yearly_price")
	private String yearlyPrice;
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	
	public String getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(String dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	public String getMonthlyPrice() {
		return monthlyPrice;
	}
	public void setMonthlyPrice(String monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}
	public String getYearlyPrice() {
		return yearlyPrice;
	}
	public void setYearlyPrice(String yearlyPrice) {
		this.yearlyPrice = yearlyPrice;
	}

}
