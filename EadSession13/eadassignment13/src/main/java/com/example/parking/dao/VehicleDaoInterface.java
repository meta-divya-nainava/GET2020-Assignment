package com.example.parking.dao;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.parking.model.PlanClass;
import com.example.parking.model.VehicleClass;
@Repository
public interface VehicleDaoInterface  extends CrudRepository<VehicleClass, Integer>{
	/**
	 * 
	 * @param type
	 * @return PlanClass Object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Query("from PlanClass where vehicleType=:vehicleType")
	PlanClass selectPlan(@Param("vehicleType")String type) throws ClassNotFoundException, SQLException;
	/**
	 * 
	 * @param vehicleType
	 * @return update daily price
	 */
	@Query("select dailyPrice from PlanClass where vehicleType=:vehicleType")
	int setDailyPriceVehicle(@Param("vehicleType") String vehicleType);
	/**
	 * 
	 * @param vehicleType
	 * @return update monthly price
	 */
	@Query("select monthlyPrice from PlanClass where vehicleType=:vehicleType")
	int setMonthlyPriceVehicle(@Param("vehicleType") String vehicleType);
	/**
	 * 
	 * @param vehicleType
	 * @return update yearly price
	 */
	@Query("select yearlyPrice from PlanClass where vehicleType=:vehicleType")
	int setYearlyPriceVehicle(@Param("vehicleType") String vehicleType);
	//int updatePlan(String passChoice,HttpSession session) throws ClassNotFoundException, SQLException;
	//public int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException;
}
