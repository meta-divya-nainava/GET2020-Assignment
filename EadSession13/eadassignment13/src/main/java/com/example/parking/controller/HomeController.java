package com.example.parking.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.parking.model.EmployeeClass;
import com.example.parking.model.UserClass;
import com.example.parking.model.ValidateSession;
import com.example.parking.model.VehicleClass;
import com.example.parking.service.EmployeeServiceInterface;
import com.example.parking.service.ServiceInterface;
import com.example.parking.service.VehicleInterface;
@Controller
public class HomeController extends ValidateSession {
	@Autowired
	private ServiceInterface serviceObject;
	@Autowired
	private VehicleInterface vehicleServiceObject;
	@Autowired
	private EmployeeServiceInterface employeeServiceObject;
	/**
	 * 
	 * @param model
	 * @return login
	 */
	@GetMapping({"/employeelogin"})
	public String login(Model model) 
	{
		model.addAttribute("userObject",new UserClass());
		
		return "login";
	}
	/**
	 * 
	 * @param model
	 * @return customSecurityPage
	 */
	@GetMapping({"/","/login"})
	public String login1(Model model) 
	{
		return "customSecurityLoginPage";
	}
	/**
	 * 
	 * @param model
	 * @return login
	 */
	@PostMapping("/login")
	public String dologin(Model model)
	{
		model.addAttribute("userObject",new UserClass());
		return "login";
		
	}
	
	/**
	 * 
	 * @param userObject
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @param response
	 * @return home else login
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@PostMapping("/employeelogin")
	public String dologin(@Validated @ModelAttribute("userObject") UserClass userObject, BindingResult bindingResult ,Model model,HttpSession session,HttpServletResponse response) throws ClassNotFoundException, SQLException {
		System.out.println("post login");
		if(bindingResult.hasErrors()) {
			
			return "login";
		}else {
			if(serviceObject.validCredential(userObject.getUserEmail(),userObject.getPassword())>0)
			{
				
				session.setAttribute("empId", employeeServiceObject.getEmployeeId(userObject.getUserEmail()));
				System.out.println("empId="+(int)session.getAttribute("empId"));
				EmployeeClass employeeObject=employeeServiceObject.getEmployee((int)session.getAttribute("empId"));
				VehicleClass vehicleObject=vehicleServiceObject.getVehicle((int)session.getAttribute("empId"));
				model.addAttribute("employeeObject",employeeObject);
				model.addAttribute("vehicleObject",vehicleObject);
				String imageName=employeeServiceObject.getEmployeeImage((int)session.getAttribute("empId"));
				session.setAttribute("imageName", imageName);
				if(isSessionValid(session, response))
				{
					model.addAttribute("imageName",session.getAttribute("imageName"));
					return "home";
				}
				else
				{
					model.addAttribute("userObject",new UserClass());

					return "login";
				}
				//return "redirect:/home";
			}
			else
			{
				model.addAttribute("message", "Invalid login");
				model.addAttribute("userObject",new UserClass());
				return "login";
			}
		

}
		
	}
	/**
	 * 
	 * @param id
	 * @param model
	 * @param response
	 * @param session
	 * @return home else login
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@GetMapping("/home/{id}")
	public String friend(@PathVariable("id") int id,Model model,HttpServletResponse response,HttpSession session) throws ClassNotFoundException, SQLException {
		if(isSessionValid(session, response))
		{
			EmployeeClass employeeObject=employeeServiceObject.getEmployee(id);
			VehicleClass vehicleObject=vehicleServiceObject.getVehicle(id);
			model.addAttribute("employeeObject",employeeObject);
			model.addAttribute("vehicleObject",vehicleObject);
			String imageName=employeeServiceObject.getEmployeeImage(id);
			model.addAttribute("imageName",imageName);
			
			return "home";
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
	 * @return signup
	 */
	@GetMapping({"/signup"})
	public String register(Model model) 
	{
		model.addAttribute("employeeObject",new EmployeeClass());
		
		return "signup";
	}
	/**
	 * 
	 * @param model
	 * @param session
	 * @param response
	 * @param request
	 * @return login when successfully logout.
	 */
	@GetMapping({"/logout1"})
	public String logOut(Model model,HttpSession session,HttpServletResponse response,HttpServletRequest request) 
	{
		model.addAttribute("userObject",new UserClass());
		session.removeAttribute("empId");
		model.addAttribute("userObject",new UserClass());
		
		return "login";
	}
	
	
}
