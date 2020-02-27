package com.example.parking.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.parking.model.EmployeeClass;
import com.example.parking.model.UserClass;
import com.example.parking.model.ValidateSession;
import com.example.parking.model.VehicleClass;
import com.example.parking.service.EmployeeServiceInterface;
import com.example.parking.service.ServiceInterface;
import com.example.parking.service.VehicleInterface;

@Controller
public class EmployeeController extends ValidateSession{
	@Autowired
	private EmployeeServiceInterface serviceObject;
	@Autowired
	private VehicleInterface vehicleServiceObject;
	String uploadDirectory= System.getProperty("user.dir")+"\\src\\main\\resources\\static\\image\\";
	/**
	 * 
	 * @param employeeObject
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return vehicle.jsp if successfully added else signup.jsp
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@PostMapping("/signup")
	public String dosignup(@Validated @ModelAttribute("employeeObject") EmployeeClass employeeObject, BindingResult bindingResult ,Model model,HttpSession session) throws ClassNotFoundException, SQLException {
		
		if(bindingResult.hasErrors()) {
			
			return "signup";
		}else {
			if(serviceObject.isEmailExist(employeeObject.getEmail()))
			{
				model.addAttribute("existEmail","Email already exist");
				return "signup";
			}
			else
			{
			if(serviceObject.addEmployee(employeeObject)>0)
			{
				session.setAttribute("empId", serviceObject.getEmployeeId(employeeObject.getEmail()));
				model.addAttribute("empId",serviceObject.getEmployeeId(employeeObject.getEmail()));
				model.addAttribute("vehicleObject",new VehicleClass());
				session.setAttribute("imageName", "profile.png");
				return "vehicle";
			}
			else
			{
				return "signup";
			}
			}
			

}
		}
	/**
	 * 
	 * @param model
	 * @param session
	 * @param response
	 * @return to update if session valid else login
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@GetMapping("/update")
	public String employees(Model model,HttpSession session,HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		if(isSessionValid(session, response))
		{
			model.addAttribute("employeeObject",serviceObject.getEmployee((int)session.getAttribute("empId")));
			model.addAttribute("imageName",session.getAttribute("imageName"));
			return "update";
		}
		else
		{
			model.addAttribute("userObject",new UserClass());

			return "login";
		}
		
		}
	/**
	 * 
	 * @param employeeObject
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return to vehicle.jsp if successful else update.jsp
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@PostMapping("/update")
	public String doupdate(@Validated @ModelAttribute("employeeObject") EmployeeClass employeeObject, BindingResult bindingResult ,Model model,HttpSession session) throws ClassNotFoundException, SQLException {
		if(bindingResult.hasErrors()) {
			return "update";
		}else {
			if(serviceObject.updateEmployee(employeeObject,session)>0)
			{
				model.addAttribute("vehicleObject",vehicleServiceObject.getVehicle((int)session.getAttribute("empId")));
				return "vehicle";
			}else
			{
				
				return"update";
			}
			

}
	}
	/**
	 * 
	 * @param model
	 * @param session
	 * @param response
	 * @return friend.jsp if session valid else  login
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@GetMapping("/friend")
	public String friendList(Model model,HttpSession session,HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		if(isSessionValid(session, response))
		{
			model.addAttribute("friendList", serviceObject.showFriends(session));
			model.addAttribute("imageName",session.getAttribute("imageName"));
			return "friend";
		}
		else
		{
			model.addAttribute("userObject",new UserClass());

			return "login";
		}
		
	}
	/**
	 * 
	 * @param model
	 * @return imageupload.jsp
	 */
	@GetMapping("/upload")
	public String logout(Model model) {
	System.out.println("img");
	return "imageUpload";
	}
	/**
	 * 
	 * @param model
	 * @param img
	 * @param session
	 * @param response
	 * @return home if session valid else login
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@PostMapping("/upload")
	public String upload(Model model, @RequestParam("file") MultipartFile img, HttpSession session,HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {
	if(img.getOriginalFilename()==null || img.getOriginalFilename().length()==0)
	{
		return "home";
	}
	Path fileNameAndPath = Paths.get(uploadDirectory,img.getOriginalFilename());
	System.out.println(fileNameAndPath);
	Files.write(fileNameAndPath, img.getBytes());
	System.out.println(fileNameAndPath);
	serviceObject.setEmployeeImage((int) session.getAttribute("empId"), img.getOriginalFilename());
	String imageName=serviceObject.getEmployeeImage((int) session.getAttribute("empId"));

	if(isSessionValid(session, response))
	{
		session.setAttribute("imageName", imageName);
		EmployeeClass employeeObject=serviceObject.getEmployee((int) session.getAttribute("empId"));
		VehicleClass vehicleObject=vehicleServiceObject.getVehicle((int) session.getAttribute("empId"));
		model.addAttribute("employeeObject",employeeObject);
		model.addAttribute("vehicleObject",vehicleObject);
		model.addAttribute("imageName",session.getAttribute("imageName"));
		return "home";
	}
	else
	{
		model.addAttribute("userObject",new UserClass());

		return "login";
	}
	}
	
}
