package com.example.student.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.dao.StudentDao;
import com.example.student.model.StudentClass;
import com.example.student.service.StudentService;
@Service

public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public int addStudent(StudentClass studentObject) {
		studentDao.addStudent(studentObject);
		return 0;
	}

	@Override
	public StudentClass getStudent(int id) {
		return studentDao.getStudent(id);
		
	}

	@Override
	public boolean deleteStudent(int id) {
		
		return studentDao.deleteStudent(id);
	}

	@Override
	public boolean updateStudent(StudentClass StudentObject) {
		
		return studentDao.updateStudent(StudentObject);
	}

	@Override
	public List<StudentClass> getAllStudent() {
		return studentDao.getAllStudent();
	}

}
