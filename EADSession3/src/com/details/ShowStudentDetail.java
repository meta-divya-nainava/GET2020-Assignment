package com.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowStudentDetail extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		
	
		Connection con=setConnection();
		HttpSession session = req.getSession();
		try {
			out.println("<html><head><title>Hello</title></head>");
			String query="select * from students";
			java.sql.Statement state= con.createStatement();
			ResultSet rs=state.executeQuery(query);
			out.println("<body><header ><a href='addStudentDetail.html'>Add student</a><a href='showStudentDetail.html'>Show student detail</a><a href='searchStudentDetail.html'>Search student detail</a></header><div>");
			out.println("<table>");
			while(rs.next())
			{
				out.println("<tr><form method=\"post\" action='updateDetails' name='form'/>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td ><input type='text' name='emailUpdate' value='"+rs.getString(4)+"'/></td>");
				out.println("<td>"+rs.getInt(5)+"</td>");
				out.println("<td>"+rs.getInt(6)+"</td>");
				out.println("<td>"+"<input type='submit' name='edit' value='Edit' />"+"</td>");
				out.println("</form></tr>");
				
			}
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
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

}
	

