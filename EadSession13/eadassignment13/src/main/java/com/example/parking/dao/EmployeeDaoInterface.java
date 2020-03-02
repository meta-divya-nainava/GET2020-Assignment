package com.example.parking.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.parking.model.EmployeeClass;
import com.example.parking.model.FriendClass;
@Repository
public interface EmployeeDaoInterface extends CrudRepository<EmployeeClass, Integer> {
	/**
	 * 
	 * @param email
	 * @return int id
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@org.springframework.data.jpa.repository.Query("select empId from EmployeeClass where email=:email")
	public int getEmployeeId(@Param("email")String email) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param empId
	 * @return list of friend employee
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Query("select empId,name from EmployeeClass where typeOfOrg=(select typeOfOrg from EmployeeClass where empId=:empId ) and empId!=:empId")
	List<Object[]> showFriends(@Param("empId") int empId) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param email
	 * @return int count
	 */
	@Query("select count(*) from EmployeeClass where email=:email")
	public int isEmailExist(@Param("email")String email);

}
