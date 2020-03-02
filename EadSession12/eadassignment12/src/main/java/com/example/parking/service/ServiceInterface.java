package com.example.parking.service;

import com.example.parking.model.EmployeeClass;

public interface ServiceInterface {
	/**
	 * 
	 * @param email
	 * @param password
	 * @return 1 if successful else 0
	 * @throws ClassNotFoundException
	 */
	public int validCredential(String email,String password) throws ClassNotFoundException;
	

}
