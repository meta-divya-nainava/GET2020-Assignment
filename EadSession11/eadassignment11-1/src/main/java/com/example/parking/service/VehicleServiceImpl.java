package com.example.parking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.parking.dao.VehicleDaoInterface;
import com.example.parking.model.PlanClass;
import com.example.parking.model.VehicleClass;
@Component
public class VehicleServiceImpl implements VehicleInterface{
	@Autowired
	private VehicleDaoInterface daoObject;

	@Override
	@Transactional
	public int addVehicle(VehicleClass vehicleObject) throws ClassNotFoundException, SQLException {
		return daoObject.addVehicle(vehicleObject);
	}

	@Override
	@Transactional
	public PlanClass selectPlan(String type) throws ClassNotFoundException, SQLException {
		return daoObject.selectPlan(type);
	}

	@Override
	@Transactional
	public int  updatePlan(String passChoice,HttpSession session) throws ClassNotFoundException, SQLException {
		return daoObject.updatePlan(passChoice,session);
	
	}
	@Override
	@Transactional
	public VehicleClass getVehicle(int empId) throws ClassNotFoundException, SQLException
	{
		return daoObject.getVehicle(empId);
	}
	@Override
	@Transactional
	public boolean isVehicleExist(int empId) throws ClassNotFoundException, SQLException
	{
		return daoObject.isVehicleExist(empId);
	}
	@Override
	@Transactional
	public int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException
	{
		return daoObject.updateVehicleData(vehicleObject);
	}
	

}
