 package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.student.model.StudentClass;
import com.example.student.service.StudentService;

@Controller
/**
 * 
 * @author Divya
 *
 */
public class HomeController {
	@Autowired
	private StudentService studentService;
	
	@Value("${home.message}")
	private String message;
	
	/**
	 * 
	 * @param model
	 * @return home page
	 */
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("msg",message);
		
		return "home";
	}
	/**
	 * 
	 * @param model
	 * @return signup page
	 */
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("student",new StudentClass());
		
		return "signup";
	}
	/**
	 * 
	 * @param studentObject
	 * @param bindingResult
	 * @return student page
	 */
	@PostMapping("/signup")
	public String doSignup(@Validated @ModelAttribute("student") StudentClass studentObject, BindingResult bindingResult ) {
		
		if(bindingResult.hasErrors()) {
			
			return "signup";
		}else {
			
			if(studentObject.getId() == null) {
				
				studentService.addStudent(studentObject);	
			}else {
				studentService.updateStudent(studentObject);
			}
			
			
			return "redirect:/students";
		}
		

		
	}

}
