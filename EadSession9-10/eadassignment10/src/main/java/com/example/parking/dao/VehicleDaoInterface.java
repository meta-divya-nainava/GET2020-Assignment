package com.example.parking.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.parking.model.VehicleClass;

public interface VehicleDaoInterface {
	/**
	 * 
	 * @param vehicleObject
	 * @return int
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int addVehicle(VehicleClass vehicleObject) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param type
	 * @return list
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	java.util.List<Map<String, Object>> selectPlan(String type) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param passChoice
	 * @param session
	 * @return int
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int updatePlan(String passChoice,HttpSession session) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param empId
	 * @return VheicleClass object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public VehicleClass getVehicle(int empId) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param empId
	 * @return boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean isVehicleExist(int empId) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param vehicleObject
	 * @return int
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException;

}
