package com.example.parking.service;

import com.example.parking.model.EmployeeClass;

public interface ServiceInterface {
	/**
	 * 
	 * @param email
	 * @param password
	 * @return true if valid else false
	 */
	public boolean validCredential(String email,String password);
	

}
