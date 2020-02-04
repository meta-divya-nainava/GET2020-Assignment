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

public class AddStudentDetail extends HttpServlet {
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
					 /*rd= req.getRequestDispatcher("/addStudentDetail.html");
				    rd.include(req, res);
				    return*/ ;
				}
				else
				{
					res.getWriter().println("Operation failed");
					/*rd= req.getRequestDispatcher("addStudentDetail.html");
				     rd.include(req, res);*/
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		private Connection setConnection()
		{
			String url="jdbc:mysql://localhost:3306/detail";
			String uName="root";
			String pass="root";
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Connection con=DriverManager.getConnection(url,uName,pass);
				return con;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		private boolean addDetail(HttpServletRequest req, HttpServletResponse res,String firstName, String lastName, String fatherName, String email, int std, int age) throws SQLException, IOException, ServletException
		{
			Connection con=setConnection();
			java.sql.Statement state= con.createStatement();
			String query= "select EXISTS (select * from students where email='"+email+"')";
			ResultSet rs= state.executeQuery(query);
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
//			        
			    
			}
			else
			{
				PreparedStatement st= (PreparedStatement) con.prepareStatement("insert into students values(?,?,?,?,?,?)");
				st.setString(1, firstName);
				st.setString(2, lastName);
				st.setString(3, fatherName);
				st.setString(4, email);
				st.setInt(5, std);
				st.setInt(6, age);
				st.executeUpdate();
				st.close();
				con.close();
	
				return true;
			}
			
		}
		
}


