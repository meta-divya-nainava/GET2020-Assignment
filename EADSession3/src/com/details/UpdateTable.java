package com.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class UpdateTable
 */
@WebServlet("/UpdateTable")
public class UpdateTable extends HttpServlet {
	DatabaseQuery queryObject=new DatabaseQuery();
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		String email= (String) session.getAttribute("email");
		String firstNameHtml=req.getParameter("firstNameHtml");
		String lastNameHtml=req.getParameter("lastNameHtml");
		String fatherNameHtml=req.getParameter("fatherNameHtml");
		String stdHtml=req.getParameter("fatherNameHtml");
		String ageHtml=req.getParameter("ageHtml");
		String emailHtml=req.getParameter("emailHtml");
		System.out.println("table="+email);
		try {
			queryObject.updateData(firstNameHtml, lastNameHtml, fatherNameHtml, stdHtml, ageHtml, email);
			if(email.equals(req.getParameter("emailHtml")))
			{
			  out.println("<script type=\"text/javascript\">");
		       out.println("alert('updated successfully');");
		       out.println("</script>");
			RequestDispatcher rd= req.getRequestDispatcher("showDetails");
			rd.include(req, res);
			}
			else
			{
				ResultSet rs= queryObject.validateEmail(emailHtml);
				rs.next();
				if(rs.getInt(1)==1)
				{
				      out.println("<script type=\"text/javascript\">");
				       out.println("alert('email already exist.');");
				       out.println("</script>");
				       res.getWriter().println("email already exist.");
				       RequestDispatcher rd= req.getRequestDispatcher("showDetails");
				       rd.include(req, res);			        
				    
				}
				else
				{
					queryObject.updateEmail(email, emailHtml);
					out.println("<script type=\"text/javascript\">");
				       out.println("alert('updated successfully');");
				       out.println("</script>");
					RequestDispatcher rd= req.getRequestDispatcher("showDetails");
					rd.include(req, res);
					
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
