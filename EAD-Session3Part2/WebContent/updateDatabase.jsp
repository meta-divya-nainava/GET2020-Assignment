<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*, com.EAD3.SetConnection" %>
    <%
    Connection con=new SetConnection().setConnection();
    java.sql.Statement st= con.createStatement();
    String plan=request.getParameter("passes");
    int price=Integer.parseInt(request.getParameter(plan));
    String query3="select email from employee where empId='"+session.getAttribute("userId")+"'";
    ResultSet rs1=st.executeQuery(query3);
    rs1.next();
    if(!(rs1.getString(1).equals(request.getParameter("email"))))
    {
    String query1= "select EXISTS (select * from employee where email='"+request.getParameter("email")+"')";
    ResultSet  rs= st.executeQuery(query1);
	rs.next();
	if(rs.getInt(1)==1)
	{
		out.println("<script type=\"text/javascript\">");
	       out.println("alert('email already exist');");
	       out.println("</script>");
	       con.close();
	       RequestDispatcher rd= request.getRequestDispatcher("update.jsp");
			rd.include(request, response);
	
	}
    }
	else
	{
			String query= "update employee set name='"+request.getParameter("name")+"', email='"+
					request.getParameter("email")+"', contactNo='"+request.getParameter("contactNo")+
					"', org='"+request.getParameter("org")+"' where empId='"+session.getAttribute("userId")+"'";
					st.executeUpdate(query);
					String query2= "update vehicleData set vehicleName='"+request.getParameter("vecName")+"',vehicleType='"+request.getParameter("type")+
							"',price='"+price+"',plan='"+plan+"',identification='"+request.getParameter("identification")+"' where empId='"+session.getAttribute("userId")+"'";
					st.executeUpdate(query2);
					out.println("<script type=\"text/javascript\">");
				       out.println("alert('updated successfully');");
				       out.println("</script>");
				       con.close();
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