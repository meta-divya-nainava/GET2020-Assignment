package com.example.parking.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.parking.dao.DaoInterface;
import com.example.parking.model.EmployeeClass;

@Service
public class ServiceUserImplementation implements ServiceInterface {
	@Autowired
	private DaoInterface daoObject;
	@Override
	public int validCredential(String email,String password) throws ClassNotFoundException
	{
		return daoObject.validCredential(email, password);
		
	}

}
