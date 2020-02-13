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
	DatabaseQuery queryObject=new DatabaseQuery();
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{

		PrintWriter out = res.getWriter();
		String email=req.getParameter("emailUpdate");
		System.out.println(email);
		HttpSession session = req.getSession();
		session.setAttribute("email", email);
		try {
			ResultSet rs=queryObject.updateDetails(email);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
