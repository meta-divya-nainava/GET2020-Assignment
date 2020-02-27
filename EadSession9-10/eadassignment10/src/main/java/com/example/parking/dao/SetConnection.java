package com.example.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;
@Component
public class SetConnection {
	Connection con=null;
	public  Connection connection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/parking";
		String uName="root";
		String pass="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,uName,pass);
		return con;
	}
	
}
