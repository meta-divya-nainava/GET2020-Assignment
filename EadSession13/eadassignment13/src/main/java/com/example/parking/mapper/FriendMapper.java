package com.example.parking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.parking.model.FriendClass;

public class FriendMapper implements RowMapper<FriendClass>{

	@Override
	public FriendClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		FriendClass friendObject=new FriendClass();
		friendObject.setEmpId(rs.getInt("EMPID"));
		friendObject.setName(rs.getString("name"));
		return friendObject;
	}

}
