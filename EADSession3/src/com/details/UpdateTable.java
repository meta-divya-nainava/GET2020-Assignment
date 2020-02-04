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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		Connection con=setConnection();
		HttpSession session = req.getSession();
		String email= (String) session.getAttribute("email");
		System.out.println("table="+email);
		try {
			java.sql.Statement st= con.createStatement();
			String query= "update Students set firstName='"+req.getParameter("firstNameHtml")+"', lastName='"+
					req.getParameter("lastNameHtml")+"', fatherName='"+req.getParameter("fatherNameHtml")+
					"', std='"+req.getParameter("stdHtml")+"', age='"+req.getParameter("ageHtml")+"' where email='"+email+"'";
			st.executeUpdate(query);
			if(email.equals(req.getParameter("emailHtml")))
			{
			  out.println("<script type=\"text/javascript\">");
		       out.println("alert('updated successfully');");
		       out.println("</script>");
		       con.close();
			RequestDispatcher rd= req.getRequestDispatcher("showDetails");
			rd.include(req, res);
			}
			else
			{
				String query1= "select EXISTS (select * from students where email='"+req.getParameter("emailHtml")+"')";
				ResultSet rs= st.executeQuery(query1);
				rs.next();
				if(rs.getInt(1)==1)
				{
						con.close();
				      out.println("<script type=\"text/javascript\">");
				       out.println("alert('email already exist.');");
				       out.println("</script>");
				       res.getWriter().println("email already exist.");
				       RequestDispatcher rd= req.getRequestDispatcher("showDetails");
				       rd.include(req, res);
//				        
				    
				}
				else
				{
					String query2= "update Students set  email='"+req.getParameter("emailHtml")+"' where email='"+email+"'";
					st.executeUpdate(query2);
					out.println("<script type=\"text/javascript\">");
				       out.println("alert('updated successfully');");
				       out.println("</script>");
				       con.close();
					RequestDispatcher rd= req.getRequestDispatcher("showDetails");
					rd.include(req, res);
					
				}
				
			}
			
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
