<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="/style.css">
    <title>Metacube Parking System</title>


</head>
<body>
<div>
<ul>
  <li><a href="/logout" style="float: left"> LogOut</a></li>
  <li><a href="/update" style="float: left;margin-left: 20px;"> Update Details</a></li>
  <li><a href="/friend" style="float: left;margin-left: 20px;">Show friendList</a></li>
  <li style="float:right"><a class="active" href="/upload"><img src="/image/${imageName}/" width="30%" ></a></li>
</ul>
</div>

    <div class="main">

        <section class="register">
            <div class="container">
            <br>
                <fieldset>
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Welcome</legend>
                    <div class="registration-content">
                        <table id="detailTable" class="registration-form">
                            <tr>
                                <td class="data"> Name</td>
                                <td id="employeename" class="data" colspan="3">${employeeObject.name}</td>
                            </tr>
                            <tr>
                                <td class="data"> Contact details</td>
                                <td id="contact" class="data" colspan="3">${employeeObject.contact}</td>
                            </tr>
                            <tr>
                                <td class="data"> Email </td>
                                <td id="emailDetail" class="data" colspan="3">${employeeObject.email}</td>
                            </tr>
                            <tr>
                                <td class="data"> Employee Id: </td>
                                <td id="employeeId1" class="data" colspan="3">${vehicleObject.empId}</td>
                            </tr>
                            <tr>
                                <td class="data"> Vehicle Name </td>
                                <td id="vehicleName" class="data" colspan="3">${vehicleObject.vehicleName}</td>
                            </tr>
                            <tr>
                                <td class="data"> Vehicle Type</td>
                                <td id="vehicleNumber" class="data" colspan="3">${vehicleObject.vehicleType}</td>
                            </tr>
                             <tr>
                                <td class="data"> Vehicle Number</td>
                                <td id="vehicleNumber" class="data" colspan="3">${vehicleObject.vehicleNumber}</td>
                            </tr>
                             <tr>
                                <td class="data">Plan</td>
                                <td id="vehicleNumber" class="data" colspan="3">${vehicleObject.plan}</td>
                            </tr>
                            <tr>
                                <td rowspan="2" class="data"> Total Bill</td>
                                <td class="data1">INR</td>
                                <td class="data1">USD</td>
                                <td class="data1">YEN</td>

                            </tr>
                            <tr>
                                <td id="billINR" class="data1">${vehicleObject.price}</td>
                                <td id="billUSD" class="data1">${vehicleObject.price}</td>
                                <td id="billYEN" class="data1">${vehicleObject.price}</td>
                            </tr>
                        </table>
                        </div>

                </fieldset>
                </div>
        </section>

        </div>
</body>

</html>