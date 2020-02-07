<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*, com.EAD3.SetConnection" %>
       <%
  					HttpSession session1=request.getSession();
       				int userId=(int)session1.getAttribute("userId");
  					Connection con1=new SetConnection().setConnection();
					java.sql.Statement state1= con1.createStatement();
					String plan=request.getParameter("passes");
					int price=Integer.parseInt(request.getParameter(plan));
					String query1= "update vehicleData set price="+price+" ,plan='"+plan+"'where empId="+userId+"";
					state1.executeUpdate(query1);
					
					state1.close();
					con1.close();
					response.sendRedirect("home.jsp");
  
					%>