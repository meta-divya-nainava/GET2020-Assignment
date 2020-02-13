<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*, com.EAD3.DatabaseQuery, java.io.PrintWriter, javax.servlet.RequestDispatcher"%>
    <%
    	DatabaseQuery queryObject=new DatabaseQuery();
    	String loginEmail=request.getParameter("loginEmail");
    	String loginPassword=request.getParameter("loginPassword");
    	ResultSet rs=queryObject.validCredential(loginEmail, loginPassword);
		rs.next();
		if(rs.getInt(1)==1)
		{
			queryObject.setLoginDetails(request, loginEmail, loginPassword);
			response.sendRedirect("home.jsp");
			
		}
		else
		{
			response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Invalid credentials');");
		    out.println("</script>");
		    RequestDispatcher rd=request.getRequestDispatcher("login.html");
		    rd.include(request, response);
		}
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>


</body>
</html>