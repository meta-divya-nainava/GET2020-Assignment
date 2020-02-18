package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.student.model.StudentClass;
import com.example.student.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	/**
	 * 
	 * @return model studentList
	 * @return view students page
	 */
	@GetMapping("/students")
	public ModelAndView students() {
		List<StudentClass> studentList =  studentService.getAllStudent();
		return new ModelAndView("students","studentList",studentList);
	}
	/**
	 * 
	 * @param id
	 * @return modelAndView
	 */
	@GetMapping("/students/{id}")
	public ModelAndView oneStudent(@PathVariable("id") int id) {
		return new ModelAndView("signup","student",studentService.getStudent(id));
	}

}
