<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="style.css">
    <title>Metacube Parking System</title>


</head>
 <%@ page import="java.sql.*, com.EAD3.DatabaseQuery" %>
        <%
       				DatabaseQuery queryObject=new DatabaseQuery();
        			String id=request.getParameter("friendId");
        			int userId=Integer.parseInt(id);
					ResultSet rs1= queryObject.showEmployeeDetail(userId);
					rs1.next();
					String name= rs1.getString(2);
					String contact=rs1.getString(6);
					String email=rs1.getString(4);
					int employeeId=rs1.getInt(1);
					ResultSet rs2= queryObject.showVehicleDetail(userId);
					rs2.next();
					String vecName= rs2.getString(2);
					String vecType=rs2.getString(3);
					int price=rs2.getInt(4);
					String plan=rs2.getString(5);
 					%>

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
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Welcome</legend>
                    <div class="registration-content">
                        <table id="detailTable" class="registration-form">
                            <tr>
                                <td class="data"> Name</td>
                                <td id="employeename" class="data" colspan="3"><%=name %></td>
                            </tr>
                            <tr>
                                <td class="data"> Contact details</td>
                                <td id="contact" class="data" colspan="3"><%=contact %></td>
                            </tr>
                            <tr>
                                <td class="data"> Email </td>
                                <td id="emailDetail" class="data" colspan="3"><%=email %></td>
                            </tr>
                            <tr>
                                <td class="data"> Employee Id: </td>
                                <td id="employeeId1" class="data" colspan="3"><%=employeeId %></td>
                            </tr>
                            <tr>
                                <td class="data"> Vehicle Name </td>
                                <td id="vehicleName" class="data" colspan="3"><%=vecName %></td>
                            </tr>
                            <tr>
                                <td class="data"> Vehicle Type</td>
                                <td id="vehicleNumber" class="data" colspan="3"><%=vecType %></td>
                            </tr>
                             <tr>
                                <td class="data">Plan</td>
                                <td id="vehicleNumber" class="data" colspan="3"><%=plan %></td>
                            </tr>
                            <tr>
                                <td rowspan="2" class="data"> Total Bill</td>
                                <td class="data1">INR</td>
                                <td class="data1">USD</td>
                                <td class="data1">YEN</td>

                            </tr>
                            <tr>
                                <td id="billINR" class="data1"><%=price %></td>
                                <td id="billUSD" class="data1"><%=price %></td>
                                <td id="billYEN" class="data1"><%=price%></td>
                            </tr>
                        </table>
                        </div>

                </fieldset>
                </div>
        </section>

        </div>
</body>

</html>