package com.EAD3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetConnection {
	Connection con=null;
	public  Connection connection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/parking";
		String uName="root";
		String pass="root";
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,uName,pass);
		return con;
	}
	
}
