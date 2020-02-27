package com.example.parking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.parking.dao.VehicleDaoInterface;
import com.example.parking.model.VehicleClass;
@Component
public class VehicleServiceImpl implements VehicleInterface{
	@Autowired
	private VehicleDaoInterface daoObject;

	@Override
	public int addVehicle(VehicleClass vehicleObject) throws ClassNotFoundException, SQLException {
		return daoObject.addVehicle(vehicleObject);
	}

	@Override
	public java.util.List<Map<String, Object>> selectPlan(String type) throws ClassNotFoundException, SQLException {
		return daoObject.selectPlan(type);
	}

	@Override
	public int  updatePlan(String passChoice,HttpSession session) throws ClassNotFoundException, SQLException {
		return daoObject.updatePlan(passChoice,session);
	
	}
	@Override
	public VehicleClass getVehicle(int empId) throws ClassNotFoundException, SQLException
	{
		return daoObject.getVehicle(empId);
	}
	@Override
	public boolean isVehicleExist(int empId) throws ClassNotFoundException, SQLException
	{
		return daoObject.isVehicleExist(empId);
	}
	@Override
	public int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException
	{
		return daoObject.updateVehicleData(vehicleObject);
	}
	

}
