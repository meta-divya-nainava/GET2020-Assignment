package com.example.parking.dao;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.parking.model.PlanClass;
import com.example.parking.model.VehicleClass;

public interface VehicleDaoInterface {
	/**
	 * 
	 * @param vehicleObject
	 * @return  1 if successful else 0
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int addVehicle(VehicleClass vehicleObject) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param type
	 * @return PlanClass object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	PlanClass selectPlan(String type) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param passChoice
	 * @param session
	 * @return 1 if successful else 0
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int updatePlan(String passChoice,HttpSession session) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param empId
	 * @return VehicleClass Object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public VehicleClass getVehicle(int empId) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param empId
	 * @return true if exist else false
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean isVehicleExist(int empId) throws ClassNotFoundException, SQLException;
/**
 * 
 * @param vehicleObject
 * @return 1 if successful else 0
 * @throws SQLException
 * @throws ClassNotFoundException
 */
	public int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException;

}
