<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*, com.EAD3.DatabaseQuery" %>
    <%
    DatabaseQuery queryObject=new DatabaseQuery();
    String plan=request.getParameter("passes");
    int price=Integer.parseInt(request.getParameter(plan));
    int userId=(int)session.getAttribute("userId");
    ResultSet rs1=queryObject.selectEmailQuery(userId);
    rs1.next();
    if(!(rs1.getString(1).equals(request.getParameter("email"))))
    {
    String email= request.getParameter("email");
    ResultSet  rs= queryObject.validateEmail(email);
	rs.next();
	if(rs.getInt(1)==1)
	{
		out.println("<script type=\"text/javascript\">");
	       out.println("alert('email already exist');");
	       out.println("</script>");
	       RequestDispatcher rd= request.getRequestDispatcher("update.jsp");
			rd.include(request, response);
	
	}
    }
	else
	{
			
					queryObject.updateEmployee(request, userId);
					queryObject.updateVehicle(request, userId, price, plan);
					
					out.println("<script type=\"text/javascript\">");
				       out.println("alert('updated successfully');");
				       out.println("</script>");
					RequestDispatcher rd= request.getRequestDispatcher("home.jsp");
					rd.include(request, response);}
					
				%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>