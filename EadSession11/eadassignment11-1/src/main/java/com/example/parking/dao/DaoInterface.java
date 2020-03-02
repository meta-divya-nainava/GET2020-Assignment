package com.example.parking.dao;

import java.sql.SQLException;

public interface DaoInterface {
	/**
	 * 
	 * 
	 * @param email
	 * @param password
	 * @return true if valid else false
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean validCredential(String email,String password) throws ClassNotFoundException, SQLException;
}
