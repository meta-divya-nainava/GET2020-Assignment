package com.example.parking.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.parking.mapper.EmployeeMapper;
import com.example.parking.mapper.FriendMapper;
import com.example.parking.model.EmployeeClass;
import com.example.parking.model.FriendClass;
import com.mysql.cj.protocol.Resultset;

@Component
public class EmployeeDaoImpl implements EmployeeDaoInterface{
	private final String SQL_INSERT_USER = "insert into employee (empId,name,gender,email,password,contactNo,org)values(empId,?,?,?,?,?,?)";
	private final String SQL_SELECT_EMPLOYEE =  "select * from employee where EMPID = ?";
	private final String SQL_SELECT_EMPLOYEEID="select EMPID from employee where email=?";
	private final String SQL_UPDATE_EMPLOYEE="update employee set name=?,gender=?, email=?, contactNo=?, org=? where empId=?";
	private final String SQL_SELECT_ORG= "select org from employee where empId=?";
	private final String SQL_SELECT_FRIEND="select empId,name from employee where org=? and empId!=?";
	private final String SQL_SELECT_IMAGE="SELECT imagename FROM image where empId=?";
	private final String SQL_SELECT_IMAGE_EMPID="select empId from image where empId =?";
	private final String SQL_INSERT_IMAGE="insert into image values(?, ?)";
	private final String SQL_UPDATE_IMAGE="update image set imageName =? where empId = ?";
	private final String SQL_EXIST_EMAIL="select * from employee where email=?";
	
	
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDaoImpl(javax.sql.DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int addEmployee(EmployeeClass employeeObject) throws ClassNotFoundException, SQLException {
		return jdbcTemplate.update(SQL_INSERT_USER, employeeObject.getName(),employeeObject.getGender(),employeeObject.getEmail(),employeeObject.getPassword(),employeeObject.getContact(),employeeObject.getTypeOfOrg());
	}
	@Override
	public int getEmployeeId(String email) throws ClassNotFoundException, SQLException
	{
		return jdbcTemplate.queryForObject(
                SQL_SELECT_EMPLOYEEID, new Object[]{email}, Integer.class);
	} 
	@Override
	public EmployeeClass getEmployee(int empId) throws ClassNotFoundException, SQLException
	{
		
		return jdbcTemplate.queryForObject(SQL_SELECT_EMPLOYEE, new Object[] { empId }, new EmployeeMapper());
		
	}
	@Override
	public int updateEmployee(EmployeeClass employeeObject,HttpSession session) throws ClassNotFoundException, SQLException
	{
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE,employeeObject.getName(),employeeObject.getGender(),employeeObject.getEmail(),employeeObject.getContact(),employeeObject.getTypeOfOrg(),session.getAttribute("empId"));
	}
	@Override
	public List<FriendClass> showFriends(HttpSession session) throws ClassNotFoundException, SQLException
	{
		String org=jdbcTemplate.queryForObject(
                SQL_SELECT_ORG, new Object[]{session.getAttribute("empId")}, String.class);
		
		return jdbcTemplate.query(SQL_SELECT_FRIEND, new Object[]{org,session.getAttribute("empId")}, new FriendMapper());
		
	}
	@Override
	public int setEmployeeImage(int empId, String imageName) throws SQLException, ClassNotFoundException
	{
		java.util.List<Map<String, Object>> imageList=jdbcTemplate.queryForList(
                SQL_SELECT_IMAGE_EMPID, new Object[]{empId});
		if(!(imageList.size()>0))
		{
			return jdbcTemplate.update(SQL_INSERT_IMAGE,empId,imageName);
			}
			else {
				return jdbcTemplate.update(SQL_UPDATE_IMAGE,imageName,empId);
			}
		}
	@Override
	public String getEmployeeImage(int empId) throws SQLException, ClassNotFoundException {
		java.util.List<Map<String, Object>> imageList=jdbcTemplate.queryForList(
                SQL_SELECT_IMAGE_EMPID, new Object[]{empId});
		if(imageList.size()>0)
		{
			return jdbcTemplate.queryForObject(
	                SQL_SELECT_IMAGE, new Object[]{empId}, String.class);
		}
		else
		{
			return "profile.png";
		}
	}
	@Override
	public boolean isEmailExist(String email)
	{
		java.util.List<Map<String, Object>> emailList=jdbcTemplate.queryForList(
                SQL_EXIST_EMAIL, new Object[]{email});
		if(emailList.size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
