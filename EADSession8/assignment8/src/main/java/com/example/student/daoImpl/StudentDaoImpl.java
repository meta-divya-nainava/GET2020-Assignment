package com.example.student.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.student.dao.StudentDao;
import com.example.student.model.StudentClass;
@Component

public class StudentDaoImpl implements StudentDao {
	static List<StudentClass> studentList = new ArrayList<StudentClass>();

	static int counter = 1;
	@Override
	public int addStudent(StudentClass studentObject) {
		studentObject.setId(counter);
		studentList.add(studentObject);
		counter++;
		return 0;
	}

	@Override
	public StudentClass getStudent(int id) {
		StudentClass studentObject=null;
		for(StudentClass itr:studentList)
		{
			if(itr.getId()==id)
			{
				studentObject=itr;
				break;
			}
		}
		return studentObject;
	}

	@Override
	public boolean deleteStudent(int id) {
		StudentClass studentObject = getStudent(id);
		int index =  studentList.indexOf(studentObject);
		studentList.remove(index);
		return true;
	}

	@Override
	public boolean updateStudent(StudentClass studentObject) {
		StudentClass oldStudent = getStudent(studentObject.getId());
		int index =  studentList.indexOf(oldStudent);
		studentList.remove(index);
		studentList.add(studentObject); 
		return true;
	}

	@Override
	public List<StudentClass> getAllStudent() {
		return studentList;
	}

}
