package com.example.student.dao;

import java.util.List;

import com.example.student.model.StudentClass;

public interface StudentDao {
	/**
	 * 
	 * @param StudentClass
	 * @return
	 */
	int addStudent(StudentClass studentObject);


	/**
	 * 
	 * @param id
	 * @return
	 */
	StudentClass getStudent(int id);


	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteStudent(int id);

	/**
	 * 
	 * @param StudentClass
	 * @return
	 */
	boolean updateStudent(StudentClass StudentObject);


	/**
	 * 
	 * @return
	 */
	List<StudentClass> getAllStudent();

}
