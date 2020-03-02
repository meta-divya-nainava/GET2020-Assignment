package com.example.parking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.parking.model.VehicleClass;

public interface VehicleInterface {
	
	int addVehicle(VehicleClass vehicleObject) throws ClassNotFoundException, SQLException;
	
	java.util.List<Map<String, Object>> selectPlan(String type) throws ClassNotFoundException, SQLException;
	int updatePlan(String passChoice,HttpSession session) throws ClassNotFoundException, SQLException;
	public VehicleClass getVehicle(int empId) throws ClassNotFoundException, SQLException;
	public boolean isVehicleExist(int empId) throws ClassNotFoundException, SQLException;
	int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException;

}
