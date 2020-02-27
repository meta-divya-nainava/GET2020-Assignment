package com.example.parking.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.parking.model.EmployeeClass;
import com.example.parking.model.PassClass;
import com.example.parking.model.UserClass;
import com.example.parking.model.ValidateSession;
import com.example.parking.model.VehicleClass;
import com.example.parking.service.EmployeeServiceInterface;
import com.example.parking.service.VehicleInterface;

@Controller
public class VehicleController extends ValidateSession{
	@Autowired
	private VehicleInterface serviceObject;
	@Autowired
	private EmployeeServiceInterface employeeServiceObject;
	/**
	 * 
	 * @param vehicleObject
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @param response
	 * @return passes if successful else vehicle
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@PostMapping("/vehicle")
	public String dovehicle(@Validated @ModelAttribute("vehicleObject") VehicleClass vehicleObject, BindingResult bindingResult ,Model model,HttpSession session,HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		if(bindingResult.hasErrors()) {
			return "vehicle";
		}else {
			if(isSessionValid(session, response))
			{
			if(serviceObject.isVehicleExist(vehicleObject.getEmpId()))
			{
				serviceObject.updateVehicleData(vehicleObject);
			}
			else
			{
				serviceObject.addVehicle(vehicleObject);
				
			}
			java.util.List<Map<String, Object>> planList=serviceObject.selectPlan(vehicleObject.getVehicleType());
			System.out.println("planList"+planList.get(0));
			System.out.println("planList"+planList.get(0).get("daily"));
			model.addAttribute("planList",planList);
			model.addAttribute("passObject",new PassClass());
			return "passes";
			}
			else
			{
				return "login";
			}
		}
			
			
		

}
	/**
	 * 
	 * @param passObject
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @param response
	 * @return home if successful else passes
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
		@PostMapping("/passes")
		public String dopasses(@Validated @ModelAttribute("passObject") PassClass passObject, BindingResult bindingResult ,Model model,HttpSession session,HttpServletResponse response) throws ClassNotFoundException, SQLException {
			
			if(bindingResult.hasErrors()) {
				return "passes";
			}else {
				if(isSessionValid(session, response))
				{
				serviceObject.updatePlan(passObject.getPassChoice(),session );
				EmployeeClass employeeObject=employeeServiceObject.getEmployee((int)session.getAttribute("empId"));
				VehicleClass vehicleObject=serviceObject.getVehicle((int)session.getAttribute("empId"));
				model.addAttribute("employeeObject",employeeObject);
				model.addAttribute("vehicleObject",vehicleObject);
				model.addAttribute("imageName",session.getAttribute("imageName"));
				
				return "home";
				}
				else
				{
					return "login";
				}
			

	}
		
}}
