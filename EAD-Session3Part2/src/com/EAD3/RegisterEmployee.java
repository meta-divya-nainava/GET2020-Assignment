package com.EAD3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;
@WebServlet ("/Register")
public class RegisterEmployee extends HttpServlet {
	DatabaseQuery queryObject=new DatabaseQuery();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name= req.getParameter("name");
		String gender= req.getParameter("gender");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String org=req.getParameter("org");
		String phoneNo=req.getParameter("contactNo");
		try {
			addDetail(req,res,name,gender,email,password,org,phoneNo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void addDetail(HttpServletRequest req, HttpServletResponse res,String name, String gender,String email, String password, String org, String phoneNo) throws SQLException, IOException, ServletException, ClassNotFoundException
	{
		
		ResultSet rs=queryObject.validateEmail(email);
		rs.next();
		if(rs.getInt(1)==1)
		{
			PrintWriter out=res.getWriter();
		
		      out.println("<script type=\"text/javascript\">");
		       out.println("alert('email already exist.');");
		       out.println("</script>");
		       RequestDispatcher rd= req.getRequestDispatcher("register.html");
		       rd.include(req, res); 
		    
		}
		else
		{
			queryObject.insertEmployeeData(req, res, name, gender, email, password, phoneNo, org);
			ResultSet rs1=queryObject.selectIdQuery(email);
			rs1.next();
			int empId1=rs1.getInt(1);
			RequestDispatcher rd= req.getRequestDispatcher("vehicle.jsp");
			req.setAttribute("empId", empId1);
			rd.include(req, res);
			 
		}
		
	}

}
