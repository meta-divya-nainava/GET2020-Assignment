package com.example.parking.model;

import javax.validation.constraints.NotBlank;

public class PassClass {
	@NotBlank
	private String PassChoice;
	private String dailyPrice;
	private String monthlyPrice;
	private String yearlyPrice;
	public String getPassChoice() {
		return PassChoice;
	}
	public void setPassChoice(String passChoice) {
		PassChoice = passChoice;
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
