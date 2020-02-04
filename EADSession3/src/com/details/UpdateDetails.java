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

import com.mysql.cj.xdevapi.Statement;

public class UpdateDetails extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{

		PrintWriter out = res.getWriter();
		Connection con=setConnection();
		String email=req.getParameter("emailUpdate");
		System.out.println(email);
		HttpSession session = req.getSession();
		session.setAttribute("email", email);
		try {
			java.sql.Statement state= con.createStatement();
			String query="select * from students where email='"+email+"'";
			ResultSet rs=state.executeQuery(query);
			out.println("<html><head><title>Hello</title><script src='studentDetail.js'></script></head>");
			while(rs.next())
			{
				System.out.println("row exist");
				out.println("<body><div><form method=\"post\" action='updateTable' name='form'/>");
				out.println("<div><input type='text' name='firstNameHtml' value='"+rs.getString(1)+"'/></div>");
				out.println("<div><input type='text' name='lastNameHtml' value='"+rs.getString(2)+"'/></div>");
				out.println("<div><input type='text' name='fatherNameHtml' value='"+rs.getString(3)+"'/></div>");
				out.println("<div><input type='text' name='emailHtml' value='"+rs.getString(4)+"'/></div>");
				out.println("<div><input type='number'max='12' min='1' name='stdHtml' value='"+rs.getInt(5)+"'/></div>");
				out.println("<div><input type='number'max='100' min='1'  name='ageHtml' value='"+rs.getInt(6)+"'/></div>");
				out.println("<div><input type='submit' name='buttonHtml' value='Save' onclick='return register()'/></div>");
				out.println("</form");
				
			
				
			}
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			con.close();
			state.close();
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
