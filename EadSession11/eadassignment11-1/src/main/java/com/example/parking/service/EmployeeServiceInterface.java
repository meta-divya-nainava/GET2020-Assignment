package com.example.parking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.parking.model.EmployeeClass;
import com.example.parking.model.FriendClass;

public interface EmployeeServiceInterface {
	/**
	 * 
	 * @param employeeObject
	 * @return 1 if successful else 0
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int addEmployee(EmployeeClass employeeObject) throws ClassNotFoundException, SQLException;
/**
 * 
 * @param email
 * @return 1 if successful else 0
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public int getEmployeeId(String email) throws ClassNotFoundException, SQLException;
/**
 * 
 * @param empId
 * @return EmployeeClass object
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public EmployeeClass getEmployee(int empId) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param employeeObject
	 * @param session
	 * @return 1 if successful else 0
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int  updateEmployee(EmployeeClass employeeObject,HttpSession session) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param session
	 * @return list of friend employee
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<FriendClass> showFriends(HttpSession session) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param empId
	 * @param imageName
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	 void setEmployeeImage(int empId, String imageName) throws SQLException, ClassNotFoundException;
	 /**
	  * 
	  * @param empId
	  * @return string image name
	  * @throws SQLException
	  * @throws ClassNotFoundException
	  */
	 String getEmployeeImage(int empId) throws SQLException, ClassNotFoundException;
/**
 * 
 * @param email
 * @return true if exist else false
 */
	 public boolean isEmailExist(String email);

}
