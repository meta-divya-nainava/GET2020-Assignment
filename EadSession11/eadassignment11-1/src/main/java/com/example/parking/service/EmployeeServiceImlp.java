package com.example.parking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.parking.dao.EmployeeDaoInterface;
import com.example.parking.model.EmployeeClass;
import com.example.parking.model.FriendClass;
@Component
public class EmployeeServiceImlp implements EmployeeServiceInterface {
	@Autowired
	private EmployeeDaoInterface daoObject;
	@Override
	@Transactional
	public int addEmployee(EmployeeClass employeeObject) throws ClassNotFoundException, SQLException {
		return (daoObject.addEmployee(employeeObject));
	}
	@Override
	@Transactional
	public int getEmployeeId(String email) throws ClassNotFoundException, SQLException
	{
		return daoObject.getEmployeeId(email);
	}
	@Override
	@Transactional
	public EmployeeClass getEmployee(int empId) throws ClassNotFoundException, SQLException
	{
		return daoObject.getEmployee(empId);
	}
	@Override
	@Transactional
	public int updateEmployee(EmployeeClass employeeObject, HttpSession session)
			throws ClassNotFoundException, SQLException {
		return daoObject.updateEmployee(employeeObject, session);
	}
	@Override
	@Transactional
	public List<FriendClass> showFriends(HttpSession session) throws ClassNotFoundException, SQLException
	{
		return daoObject.showFriends(session);
	}
	@Override
	@Transactional
	public void setEmployeeImage(int empId, String imageName) throws SQLException, ClassNotFoundException
	{
		daoObject.setEmployeeImage(empId, imageName);
	}
	@Override
	@Transactional
	public String getEmployeeImage(int empId) throws SQLException, ClassNotFoundException
	{
		return daoObject.getEmployeeImage(empId);
		
	}
	@Override
	@Transactional
	public boolean isEmailExist(String email)
	{
		return daoObject.isEmailExist(email);
	}

}
