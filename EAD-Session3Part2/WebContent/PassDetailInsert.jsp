<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*, com.EAD3.DatabaseQuery" %>
       <%
      				DatabaseQuery queryObject=new DatabaseQuery();
       				int userId=(int)session.getAttribute("userId");
  					String plan=request.getParameter("passes");
					int price=Integer.parseInt(request.getParameter(plan));
					queryObject.insertPassDetail(price, userId, plan);
					response.sendRedirect("home.jsp");
  
					%>