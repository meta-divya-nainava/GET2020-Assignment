package com.details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import jdk.nashorn.internal.ir.ForNode;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class AddStudentDetail extends HttpServlet {
		DatabaseQuery queryObject=new DatabaseQuery();
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
		{
			
			String firstName=req.getParameter("firstName");
			String lastName=req.getParameter("lastName");
			String fatherName=req.getParameter("fatherName");
			String email=req.getParameter("email");
			int  std=Integer.parseInt(req.getParameter("standard"));
			int age=Integer.parseInt(req.getParameter("age"));
			RequestDispatcher rd;
			try {
				if(addDetail(req,res,firstName,lastName,fatherName,email,std,age))
				{
					res.getWriter().println("Successfully added");
				}
				else
				{
					res.getWriter().println("Operation failed");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		private boolean addDetail(HttpServletRequest req, HttpServletResponse res,String firstName, String lastName, String fatherName, String email, int std, int age) throws SQLException, IOException, ServletException
		{
			ResultSet rs=queryObject.validateEmail(email);
			rs.next();
			if(rs.getInt(1)==1)
			{
				PrintWriter out=res.getWriter();
			
			      out.println("<script type=\"text/javascript\">");
			       out.println("alert('email already exist.');");
			       out.println("</script>");
			       res.getWriter().println("email already exist.");
			       RequestDispatcher rd= req.getRequestDispatcher("addStudentDetail.html");
			       rd.include(req, res);
			       return false;		        
			    
			}
			else
			{
				return queryObject.insertStudentData(req, res, firstName, lastName, fatherName, email, std, age);
			}
		
		
}}


