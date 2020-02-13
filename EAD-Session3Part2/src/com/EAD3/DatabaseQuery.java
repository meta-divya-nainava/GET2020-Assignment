package com.EAD3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class DatabaseQuery {
	SetConnection conObject=new SetConnection();
	Connection con=null;
	public ResultSet validateEmail(String email) throws SQLException, ClassNotFoundException
	{
		try{
		con= conObject.connection();
		java.sql.Statement state= con.createStatement();
		String query= "select EXISTS (select * from employee where email='"+email+"')";
		ResultSet rs= state.executeQuery(query);
		return rs;
		}
		finally
		{
			con.close();
		}
	}
	public void insertEmployeeData(HttpServletRequest req, HttpServletResponse res,String name, String gender, String email, String password, String phoneNo,String org) throws SQLException, ClassNotFoundException
	{
		try{
			con= conObject.connection();
			PreparedStatement st= (PreparedStatement) con.prepareStatement("insert into employee (empId,name,gender,email,password,contactNo,org)values(empId,?,?,?,?,?,?)");
			
			st.setString(1,name);
			st.setString(2,gender);
			st.setString(3,email);
			st.setString(4, password);
			st.setString(5,phoneNo);
			st.setString(6,org);
			st.executeUpdate();
		}
		finally
		{
			con.close();
		}
		
	}
	public ResultSet selectIdQuery(String email) throws SQLException, ClassNotFoundException
	{
		try
		{
			con= conObject.connection();
			java.sql.Statement state1= con.createStatement();
			String query1= "select empId  from employee where email='"+email+"'";
			ResultSet rs1= state1.executeQuery(query1);
			return rs1;
		}
		finally
		{
			con.close();
		}
	}
	public ResultSet insertVehicleData(String vecEmpId,String vecName,String type,String identification, String vecNumber) throws SQLException, ClassNotFoundException
	{
		try
		{
		    con=conObject.connection();
			PreparedStatement st= (PreparedStatement) con.prepareStatement("insert into vehicleData (empId,vehicleName,vehicleType,identification,vehicleNumber)values(?,?,?,?,?)");

			st.setInt(1,Integer.parseInt(vecEmpId));
			st.setString(2,vecName);
			st.setString(3,type);
			st.setString(4,identification);
			st.setString(5,vecNumber);
			st.executeUpdate();
			st.close();
			java.sql.Statement state1= con.createStatement();
			String query1= "select * from planData where vehicleType='"+type+"'";
			ResultSet rs1= state1.executeQuery(query1);
			return rs1;
		}
		finally
		{
			con.close();
		}
	}
	public void insertPassDetail(int price,int userId,String plan) throws ClassNotFoundException, SQLException
	{
		try
		{
			 con=conObject.connection();
			java.sql.Statement state1= con.createStatement();
			String query1= "update vehicleData set price="+price+" ,plan='"+plan+"'where empId="+userId+"";
			state1.executeUpdate(query1);
			state1.close();
		}
		finally
		{
			
			con.close();
		}
	}
	public ResultSet showEmployeeDetail(int userId) throws SQLException, ClassNotFoundException
	{
		try
		{
			con=conObject.connection();
			java.sql.Statement state1= con.createStatement();
			String query1= "select * from employee where empId='"+userId+"'";
			ResultSet rs1= state1.executeQuery(query1);
			return rs1;
		}
		finally
		{
			con.close();
		}
	}
	public ResultSet showVehicleDetail(int userId) throws SQLException, ClassNotFoundException
	{
		try
		{
			con=conObject.connection();
			java.sql.Statement state1= con.createStatement();
			String query2= "select * from vehicleData where empId='"+userId+"'";
			ResultSet rs2= state1.executeQuery(query2);
			return rs2;
		}
		finally
		{
			con.close();
		}
	}
	public ResultSet showPlanDetail(String type) throws SQLException, ClassNotFoundException
	{
		try
		{
			con=conObject.connection();
			java.sql.Statement state1= con.createStatement();
			String query3= "select * from planData where vehicleType='"+type+"'";
			ResultSet rs3= state1.executeQuery(query3);
			return rs3;
		}
		finally
		{
			con.close();
		}
	}
	public ResultSet validCredential(String loginEmail,String loginPassword) throws ClassNotFoundException, SQLException
	{
		try
		{
			con=conObject.connection();
	    	java.sql.Statement state= con.createStatement();
	    	String query= "select EXISTS (select * from employee where email='"+loginEmail+"' AND password='"+loginPassword+"')";
			ResultSet rs= state.executeQuery(query);
			return rs;
		}
		finally
		{
			con.close();
		}
	}
	public void setLoginDetails(HttpServletRequest req,String loginEmail,String loginPassword) throws ClassNotFoundException, SQLException
	{
		try
		{
			con=conObject.connection();
	    	java.sql.Statement state= con.createStatement();
			String query= "select empId from employee where email='"+loginEmail+"' AND password='"+loginPassword+"'";
			ResultSet rs1= state.executeQuery(query);
			rs1.next();
			int userId=rs1.getInt(1);
			SetIntialData object=new SetIntialData();
			object.setSession(req,userId);
			
		}
		finally
		{
			con.close();
		}
	}
	public ResultSet selectEmailQuery(int userId) throws ClassNotFoundException, SQLException
	{
		try
		{
			con=conObject.connection();
	    	java.sql.Statement st= con.createStatement();
			String query3="select email from employee where empId='"+userId+"'";
		    ResultSet rs1=st.executeQuery(query3);
		    return rs1;
		}
		finally
		{
			con.close();
		}
	}
	public void updateEmployee(HttpServletRequest request,int userId) throws ClassNotFoundException, SQLException
	{
		try
		{
			con=conObject.connection();
	    	java.sql.Statement st= con.createStatement();
			String query= "update employee set name='"+request.getParameter("name")+"', email='"+
					request.getParameter("email")+"', contactNo='"+request.getParameter("contactNo")+
					"', org='"+request.getParameter("org")+"' where empId='"+userId+"'";
					st.executeUpdate(query);
		}
		finally
		{
			con.close();
		}
	}
	public void updateVehicle(HttpServletRequest request,int userId,int price,String plan) throws ClassNotFoundException, SQLException
	{
		try
		{
			con=conObject.connection();
	    	java.sql.Statement st= con.createStatement();
	    	String query2= "update vehicleData set vehicleName='"+request.getParameter("vecName")+"',vehicleType='"+request.getParameter("type")+
					"',price='"+price+"',plan='"+plan+"',identification='"+request.getParameter("identification")+"' where empId='"+userId+"'";
			st.executeUpdate(query2);
		}
		finally
		{
			con.close();
		}
	}
	public ResultSet showFriends(int userId) throws ClassNotFoundException, SQLException
	{
		try
		{
			con=conObject.connection();
			java.sql.Statement state1= con.createStatement();
			String query1= "select org from employee where empId='"+userId+"'";
			ResultSet rs1= state1.executeQuery(query1);
			rs1.next();
			String org=rs1.getString(1);
			String query2="select empId,name from employee where org='"+org+"'";
			rs1=state1.executeQuery(query2);
			return rs1;
		}
		finally
		{
			con.close();
		}
	}

}
