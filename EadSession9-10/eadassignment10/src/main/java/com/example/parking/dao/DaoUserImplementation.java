package com.example.parking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component("userDao")
public class DaoUserImplementation implements DaoInterface{
	private JdbcTemplate jdbcTemplate;
	private final String SQL_SELECT_EMPLOYEEID="select empId from employee where email=? AND password=?";	
	@Autowired
	public DaoUserImplementation(javax.sql.DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean validCredential(String email,String password) throws ClassNotFoundException, SQLException
	{
		java.util.List<Map<String, Object>> userList=jdbcTemplate.queryForList(
                SQL_SELECT_EMPLOYEEID, new Object[]{email,password});
		if(userList.size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
