package com.example.parking.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.parking.dao.DaoInterface;
import com.example.parking.model.EmployeeClass;

@Service
@Component("userService")
public class ServiceUserImplementation implements ServiceInterface {
	@Autowired
	@Qualifier("userDao")
	private DaoInterface daoObject;
	@Override
	public boolean validCredential(String email,String password)
	{
		try {
			if(daoObject.validCredential(email, password))
					{
				return true;
					}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
