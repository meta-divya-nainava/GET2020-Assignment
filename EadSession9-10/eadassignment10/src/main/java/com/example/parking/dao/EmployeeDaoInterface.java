package com.example.parking.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.parking.model.EmployeeClass;
import com.example.parking.model.FriendClass;

public interface EmployeeDaoInterface {
	/**
	 * 
	 * @param employeeObject
	 * @return int
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int addEmployee(EmployeeClass employeeObject) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param email
	 * @return int
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	 int getEmployeeId(String email) throws ClassNotFoundException, SQLException;
	 /**
	  * 
	  * @param empId
	  * @return EmployeeClass object
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	EmployeeClass getEmployee(int empId) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param employeeObject
	 * @param session
	 * @return int
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int  updateEmployee(EmployeeClass employeeObject,HttpSession session) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param session
	 * @return list of FreindClass object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<FriendClass> showFriends(HttpSession session) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param empId
	 * @param imageName
	 * @return int
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	 int setEmployeeImage(int empId, String imageName) throws SQLException, ClassNotFoundException;
	 /**
	  * 
	  * @param empId
	  * @return String imageName
	  * @throws SQLException
	  * @throws ClassNotFoundException
	  */
	String getEmployeeImage(int empId) throws SQLException, ClassNotFoundException;
	/**
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean isEmailExist(String email);

}
