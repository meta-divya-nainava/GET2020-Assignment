<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*, com.EAD3.DatabaseQuery,com.EAD3.SetIntialData" %>
     <%
 SetIntialData object= new SetIntialData();
object.removeCache(request, response);
%>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="style.css">
    <title>Metacube Parking System</title>


    <script src="javascript.js"></script>


</head>

<body>
<header >
<a href="home.jsp" style="float: left"> Home</a>
<a href="update.jsp" style="float: left;margin-left: 20px;"> Update Details</a>
<a href="friend.jsp" style="float: left;margin-left: 20px;">Show friendList</a>
</header>
    <div class="main">

        <section class="register">
            <div class="container">
                <fieldset>
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Register for Metacube parking</legend>
                    
                    <div class="registration-content">
                        <table id="detailTable" class="registration-form">
                                <%
                    DatabaseQuery queryObject=new DatabaseQuery();
					out.println("<html><head> <link rel='stylesheet' href='style.css'><title>Hello</title></head>");
					out.println("<body><div>");
					out.println("<table>");
					int userId=(int)session.getAttribute("userId");
					ResultSet rs1=queryObject.showFriends(userId);
					while(rs1.next())
					{%>
                            <tr>
                                <td> <%=rs1.getInt(1) %></td>
                                <td><a href="friendProfile.jsp?friendId=<%=rs1.getInt(1) %>"> <%= rs1.getString(2)%></a></td>
                            </tr>
                            <%} %>
                         
                        </table>
                        </div>

                </fieldset>
                </div>
        </section>

        </div>
</body>

</html>
