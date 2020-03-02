package com.example.parking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.parking.model.PlanClass;
import com.example.parking.model.VehicleClass;

public interface VehicleInterface {
	/**
	 * 
	 * @param vehicleObject
	 * @return 1 if successful else 0
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int addVehicle(VehicleClass vehicleObject) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param type
	 * @return PlanClassObject
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	PlanClass selectPlan(String type) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param empId
	 * @return VehicleClass object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public VehicleClass getVehicle(int empId) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param empId
	 * @return true if vehicle exist else false
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
	int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException;
	/**
	 * 
	 * @param passChoice
	 * @param vehicleType
	 * @return 1 if successful
	 */
	int setPriceVehicle(String passChoice,String vehicleType);

}
