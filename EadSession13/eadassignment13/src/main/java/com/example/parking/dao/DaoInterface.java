package com.example.parking.dao;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.parking.model.EmployeeClass;
import com.example.parking.model.UserClass;
@Repository
public interface DaoInterface extends CrudRepository<EmployeeClass, Integer> {
	/**
	 * 
	 * @param email
	 * @param password
	 * @return int id
	 */
	@Query("select empId from EmployeeClass where email=:email AND password=:password")
	public int validCredential(@Param("email")String email,@Param("password")String password);
}
