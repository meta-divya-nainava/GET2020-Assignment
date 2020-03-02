package com.example.parking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.parking.model.EmployeeClass;
import com.example.parking.model.FriendClass;

public interface EmployeeServiceInterface {
	
	int addEmployee(EmployeeClass employeeObject) throws ClassNotFoundException, SQLException;
	public int getEmployeeId(String email) throws ClassNotFoundException, SQLException;
	public EmployeeClass getEmployee(int empId) throws ClassNotFoundException, SQLException;
	int  updateEmployee(EmployeeClass employeeObject,HttpSession session) throws ClassNotFoundException, SQLException;
	public List<FriendClass> showFriends(HttpSession session) throws ClassNotFoundException, SQLException;
	 void setEmployeeImage(int empId, String imageName) throws SQLException, ClassNotFoundException;
	 String getEmployeeImage(int empId) throws SQLException, ClassNotFoundException;
	 public boolean isEmailExist(String email);

}
