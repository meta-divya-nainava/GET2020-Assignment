package com.example.parking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component("userDao")
public class DaoUserImplementation implements DaoInterface{
	@Autowired
	private EntityManager entityManager;
	private final String SQL_SELECT_EMPLOYEEID="select empId from EmployeeClass where email=:email AND password=:password";	
	@Override
	public boolean validCredential(String email,String password) throws ClassNotFoundException, SQLException
	{
		Session currentSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query query= currentSession.createQuery(SQL_SELECT_EMPLOYEEID);
		query.setParameter("email", email);
		query.setParameter("password",password);
		if(query.list().size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
