package com.example.parking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.parking.dao.VehicleDaoInterface;
import com.example.parking.dao.planDao;
import com.example.parking.model.PlanClass;
import com.example.parking.model.VehicleClass;
@Service
public class VehicleServiceImpl implements VehicleInterface{
	@Autowired
	private VehicleDaoInterface daoObject;
	
	@Autowired
	private planDao plandao;

	@Override
	@Transactional
	public int addVehicle(VehicleClass vehicleObject) throws ClassNotFoundException, SQLException {
		 daoObject.save(vehicleObject);
		 return 1;
	}

	@Override
	@Transactional
	public PlanClass selectPlan(String type) throws ClassNotFoundException, SQLException {
		//create
		return daoObject.selectPlan(type);
	}
	@Override
	@Transactional
	public VehicleClass getVehicle(int empId) throws ClassNotFoundException, SQLException
	{
		return daoObject.findById(empId).orElse(null);
	}
	@Override
	@Transactional
	public boolean isVehicleExist(int empId) throws ClassNotFoundException, SQLException
	{
		return daoObject.existsById(empId);
	}
	@Override
	@Transactional
	public int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException
	{
		 daoObject.save(vehicleObject);
		 return 1;
	}
	@Override
	@Transactional
	public int setPriceVehicle(String passChoice,String vehicleType)
	{
		if(passChoice.toLowerCase().equals("daily"))
		{
			return daoObject.setDailyPriceVehicle(vehicleType);
		}
		else if(passChoice.toLowerCase().equals("monthly"))
		{
			return daoObject.setMonthlyPriceVehicle(vehicleType);
		}
		else if(passChoice.toLowerCase().equals("yearly"))
		{
			return daoObject.setYearlyPriceVehicle(vehicleType);
		}
		else
		{
			return 0;
		}
	}

	

}
