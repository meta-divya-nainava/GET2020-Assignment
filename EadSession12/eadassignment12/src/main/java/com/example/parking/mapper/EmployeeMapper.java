package com.example.parking.mapper;

import javax.swing.tree.RowMapper;
import com.example.parking.model.EmployeeClass;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements org.springframework.jdbc.core.RowMapper<EmployeeClass>{
/**
 * method for set resultset into employeeObject
 */
	@Override
	public EmployeeClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeClass employeeObject=new EmployeeClass();
		employeeObject.setName(rs.getString("name"));
		employeeObject.setContact(rs.getString("contactNo"));
		employeeObject.setEmail(rs.getString("email"));
		employeeObject.setGender(rs.getString("gender"));
		employeeObject.setPassword(rs.getString("password"));
		System.out.println("pass:"+rs.getString("password"));
		employeeObject.setTypeOfOrg(rs.getString("org"));
		return employeeObject;
	}

}
