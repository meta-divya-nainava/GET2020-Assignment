package com.Inventory1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * The Class SetConnection.
 */
public class SetConnection {
	
	 private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    private final String DB_URL = "jdbc:mysql://localhost/Book";
	    private final String DB_user  = "root";
	    private final String DB_PASS = "root";
	    private Connection con = null;
	    public Connection connection(){
	        try {
	            Class.forName(JDBC_DRIVER);
	            con = (Connection) DriverManager.getConnection(DB_URL, DB_user,
	                    DB_PASS);
	            return con;
	        } catch (Exception e) {
	            System.out.println("Error : "+e.getMessage());
	        }
			return con;
	    }

}
