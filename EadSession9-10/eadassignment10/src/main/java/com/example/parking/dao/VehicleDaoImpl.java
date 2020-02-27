package com.example.parking.dao;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import java.awt.List;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.parking.mapper.VehicleMapper;
import com.example.parking.model.VehicleClass;
@Component
public class VehicleDaoImpl implements VehicleDaoInterface{
	private JdbcTemplate jdbcTemplate;
	
	
	
	private final String SQL_INSERT_VEHCILE="insert into vehicleData (empId,vehicleName,vehicleType,identification,vehicleNumber)values(?,?,?,?,?)";
	private final String SQL_SELECT_PLAN="select * from planData where vehicleType=?";
	private final String SQL_SELECT_VEHICLE="select * from vehicledata where empId=?";
	private final String SQL_SELECT_UPDATE_VEHICLE="update vehicleData set vehicleName=?,vehicleType=?,identification=?,vehicleNumber=? where empId=?";
	private final String SQL_SELECT_VEHICLE_TYPE="select vehicleType from vehicledata where empId=?";
	private  String SQL_SELECT_VEHICLE_PLAN;
	private final String SQL_UPDATE_VEHICLE_PLAN="update vehicledata set price=?,plan=? where empId=?";
	
	@Autowired
	public VehicleDaoImpl(javax.sql.DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int addVehicle(VehicleClass vehicleObject) throws ClassNotFoundException, SQLException {
		 return jdbcTemplate.update(SQL_INSERT_VEHCILE,vehicleObject.getEmpId(), vehicleObject.getVehicleName(),vehicleObject.getVehicleType(),vehicleObject.getIdentification(),vehicleObject.getVehicleNumber());
	}
	@Override
	public java.util.List<Map<String, Object>> selectPlan(String type) throws ClassNotFoundException, SQLException
	{
		java.util.List<Map<String, Object>> planList=jdbcTemplate.queryForList(SQL_SELECT_PLAN, new Object[]{type});
			return planList;
		
	}
	@Override
	public int updatePlan(String passChoice,HttpSession session) throws ClassNotFoundException, SQLException
	{
		SQL_SELECT_VEHICLE_PLAN="select "+passChoice.toLowerCase()+" from planData where vehicleType=?";
		String vehicleType=jdbcTemplate.queryForObject(SQL_SELECT_VEHICLE_TYPE, new Object[] {session.getAttribute("empId")},String.class);
		int price=jdbcTemplate.queryForObject(SQL_SELECT_VEHICLE_PLAN, new Object[] {vehicleType},Integer.class);
		return jdbcTemplate.update(SQL_UPDATE_VEHICLE_PLAN,price,passChoice,session.getAttribute("empId"));
		
	}
	@Override
	public VehicleClass getVehicle(int empId) throws ClassNotFoundException, SQLException
	{
		return jdbcTemplate.queryForObject(SQL_SELECT_VEHICLE, new Object[] {empId},new VehicleMapper());
	}
	@Override
	public boolean isVehicleExist(int empId) throws ClassNotFoundException, SQLException
	{
		System.out.println(jdbcTemplate.queryForList(SQL_SELECT_VEHICLE, new Object[]{empId}));
		java.util.List<Map<String, Object>> vehicleList=jdbcTemplate.queryForList(SQL_SELECT_VEHICLE, new Object[]{empId});
			if(vehicleList.size()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		
	}
	@Override
	public int updateVehicleData(VehicleClass vehicleObject) throws SQLException, ClassNotFoundException
	{
		return jdbcTemplate.update(SQL_SELECT_UPDATE_VEHICLE,vehicleObject.getVehicleName(),vehicleObject.getVehicleType(),vehicleObject.getIdentification(),vehicleObject.getVehicleNumber(),vehicleObject.getEmpId());
	}

}
