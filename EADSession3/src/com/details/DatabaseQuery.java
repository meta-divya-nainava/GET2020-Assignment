package com.details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseQuery {
	SetConnection conObject=new SetConnection();
	Connection con=null;
	public ResultSet validateEmail(String email) throws SQLException
	{
		try{
		con= new SetConnection().connection();
		java.sql.Statement state= con.createStatement();
		String query= "select EXISTS (select * from students where email='"+email+"')";
		ResultSet rs= state.executeQuery(query);
		return rs;
		}
		finally
		{
			con.close();
		}
	}
	public boolean insertStudentData(HttpServletRequest req, HttpServletResponse res,String firstName, String lastName, String fatherName, String email, int std, int age) throws SQLException
	{
		try{
		PreparedStatement st= (PreparedStatement) con.prepareStatement("insert into students values(?,?,?,?,?,?)");
		st.setString(1, firstName);
		st.setString(2, lastName);
		st.setString(3, fatherName);
		st.setString(4, email);
		st.setInt(5, std);
		st.setInt(6, age);
		st.executeUpdate();
		st.close();
		return true;
		}
		finally
		{
			con.close();
		}
		
	}
	public ResultSet searchStudentData(String nameFirst, String nameLast) throws SQLException
	{
		try
		{
		con=conObject.connection();
		java.sql.Statement st= con.createStatement();
		String query="select * from students where firstName='"+nameFirst+ "' AND lastName='"+nameLast+"'";
		ResultSet rs= st.executeQuery(query);
		return rs;
		}
		finally
		{
			con.close();
		}
	}
	public ResultSet searchClassData(int std) throws SQLException
	{
		try
		{
			con=conObject.connection();
			java.sql.Statement st= con.createStatement();
			String query="select * from students where std='"+std+ "'";
			ResultSet rs= st.executeQuery(query);
			return rs;
		}
		finally
		{
			con.close();
		}
	}
	public ResultSet showData() throws SQLException
	{
		try
		{
			con=conObject.connection();
			String query="select * from students";
			java.sql.Statement state= con.createStatement();
			ResultSet rs=state.executeQuery(query);
			return rs;
		}
		finally
		{
			con.close();
		}
	}
	public ResultSet updateDetails(String email) throws SQLException
	{
		try
		{
			con=conObject.connection();
			java.sql.Statement state= con.createStatement();
			String query="select * from students where email='"+email+"'";
			ResultSet rs=state.executeQuery(query);
			return rs;
		}
		finally
		{
			con.close();
		}
	}
	public void updateData(String firstNameHtml, String lastNameHtml,String fatherNameHtml,String stdHtml,String ageHtml,String email) throws SQLException
	{
		try
		{
			con=conObject.connection();
			java.sql.Statement st= con.createStatement();
			String query= "update Students set firstName='"+firstNameHtml+"', lastName='"+
					lastNameHtml+"', fatherName='"+fatherNameHtml+
					"', std='"+stdHtml+"', age='"+ageHtml+"' where email='"+email+"'";
			st.executeUpdate(query);
		}
		finally
		{
			con.close();
		}
	}
	public void updateEmail(String email,String emailHtml) throws SQLException
	{
		try
		{
			con=conObject.connection();
			java.sql.Statement st= con.createStatement();
			String query2= "update Students set  email='"+emailHtml+"' where email='"+email+"'";
			st.executeUpdate(query2);
		}
		finally
		{
			con.close();
		}
	}
	

}
