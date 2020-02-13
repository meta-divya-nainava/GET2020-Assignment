package com.details;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

public class SearchStudentDetail extends HttpServlet {
	DatabaseQuery queryObject=new DatabaseQuery();
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String Name=req.getParameter("searchName");
		String name[]=Name.split(" ");
		String std=req.getParameter("searchClass");
		if(name.length==2)
		{
		try {
			System.out.println("inside try of search student");
			searchStudent(req,res,Name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(std.length()!=0)
		{
		try {
			int stdInt=Integer.parseInt(std);
			classData(req,res,stdInt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			res.getWriter().println("please enter valid data");
		}
		
	}
	private void classData(HttpServletRequest req, HttpServletResponse res,int std) throws SQLException, IOException
	{
		ResultSet rs=queryObject.searchClassData(std);
		if(rs.next())
		{
		while(rs.next())
		{
			res.getWriter().println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6));
		}}
		else
		{
			res.getWriter().println("data not found");
		}
	}
	private void searchStudent(HttpServletRequest req, HttpServletResponse res,String Name) throws SQLException, IOException
	{
		String name[]=Name.split(" ");
		String nameFirst=name[0];
		String nameLast=name[1];
		ResultSet rs= queryObject.searchStudentData(nameFirst, nameLast);
		
		if(rs.next())
		{
			res.getWriter().println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6));
		}
		else
		{
			res.getWriter().println("data not found");
		}
		
	}
}
