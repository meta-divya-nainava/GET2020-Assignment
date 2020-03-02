package com.example.parking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.parking.model.VehicleClass;

public class VehicleMapper implements RowMapper<VehicleClass>{

	@Override
	public VehicleClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		VehicleClass vehicleObject=new VehicleClass();
		vehicleObject.setEmpId(rs.getInt("empId"));
		vehicleObject.setIdentification(rs.getString("identification"));
		vehicleObject.setPlan(rs.getString("plan"));
		vehicleObject.setPrice(rs.getInt("price"));
		vehicleObject.setVehicleName(rs.getString("vehicleName"));
		vehicleObject.setVehicleNumber(rs.getString("vehicleNumber"));
		vehicleObject.setVehicleType(rs.getString("VehicleType"));
		return vehicleObject;
	}

}
