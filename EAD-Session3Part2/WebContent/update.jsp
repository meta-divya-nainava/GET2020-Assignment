<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*, com.EAD3.SetConnection" %>
        <%
  					int userId=(int)session.getAttribute("userId");
  					Connection con=new SetConnection().setConnection();
					java.sql.Statement state1= con.createStatement();
					String query1= "select * from employee where empId='"+userId+"'";
					ResultSet rs1= state1.executeQuery(query1);
					rs1.next();
					String name= rs1.getString(2);
					String contact=rs1.getString(6);
					String email=rs1.getString(4);
					int employeeId=rs1.getInt(1);
					String query2= "select * from vehicleData where empId='"+userId+"'";
					ResultSet rs2= state1.executeQuery(query2);
					rs2.next();
					String vecName= rs2.getString(2);
					String type=rs2.getString(3);
					String identification=rs2.getString(6);
					String query3= "select * from planData where vehicleType='"+type+"'";
					ResultSet rs3= state1.executeQuery(query3);
					rs3.next();
					int daily=rs3.getInt(2);
					int monthly=rs3.getInt(3);
					int yearly=rs3.getInt(4);
					state1.close();
					con.close();
  
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
<a href="home.jsp" style="float: left">Home</a>
<a href="update.jsp" style="float: left;margin-left: 20px;"> Update Details</a>
<a href="friend.jsp" style="float: left;margin-left: 20px;">Show friendList</a>
</header>
    <div class="main">

        <section class="register">
            <div class="container">
                <fieldset>
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Update for Metacube parking</legend>
                    <div class="registration-content">
                        <form id="registrationform" class="registration-form" method="post" action="updateDatabase.jsp">
                            <div class="group">
                                <input type="text" class="form-input" name="name" id="name" placeholder="Your Name" value='<%=name %>' />
                                <p id="nameAlert" style="font-size:small; font-weight: 500; color:rgb(56, 54, 54); padding-bottom:-20px; margin-bottom: 1px;">Please enter valid name</p>
                            </div>
                            <div class="group">
                                <input type="text" class="form-input" name="contactNo" id="number"  maxlength="10" placeholder="Enter contact number" value='<%=contact %>'/>
                                <p id="numberAlert" style="font-size:small; font-weight: 500; color:rgb(56, 54, 54); padding-bottom:-20px; margin-bottom: 1px;">Please enter valid number</p>
                            </div>
                            <div class="group">
                                <input type="email" class="form-input" name="email" id="email" placeholder="Your Email" value='<%=email %>'/>
                                <p id="emailAlert" style="font-size:small; font-weight: 500; color:rgb(56, 54, 54); padding-bottom:-20px; margin-bottom: 1px;">Please enter valid email</p>
                            </div>
                             <div class="group">
                                <select class="form-input" id="typeOforg" name="org">
                                        <option class="form-input" value="M1" >M1</option>
                                        <option  class="form-input" value="M2" >M2</option>
                                        <option class="form-input" value="M3">M3</option>
                                         <option class="form-input" value="M4" >M4</option>
                                      </select>
                            </div>
                            <div class="group">
                                <input type="button" name="submit" id="submit" class="form-submit" value="Register" onclick="employeeRegister()" />
                            </div>
                            <div class="group">
                                <input type="text" class="form-input" name="vecEmpId" id="employeeId" readonly value=<%=employeeId%>>
                            </div>
                            <div class="group">
                                <input type="text" class="form-input" name="vecName" id="vecname" placeholder="Vehicle Name" value='<%=vecName %>' />
                                <p id="vecNameAlert" style="font-size:small; font-weight: 500; color:rgb(56, 54, 54); padding-bottom:-20px; margin-bottom: 1px;">Please enter valid vehicle number</p>
                            </div>
                            <div class="group">
                                <select class="form-input" id="typeOfVehicle" name="type">
                                        <option class="form-input" value="MotorCycle">MotorCycle</option>
                                        <option  class="form-input" value="Cycle"  >Cycle</option>
                                        <option class="form-input" value="FourWheelers">Four-Wheelers</option>
                                      </select>
                            </div>

                            <div class="group">
                                <textarea placeholder="describe vehicle identifications" class="form-input" name="identification" value='<%=identification%>'><%=identification%></textarea>
                            </div>
                            <div class="group">
                                <input type="button" name="submit" id="submit" class="form-submit" value="Get Passes" onclick=" return  vehicleRegister()"  />
                            </div>
                            <div class="group">
                                <input type="radio" name="passes" value="Daily" id="daily" checked>Daily
                                <input type="text" name="Daily" style="margin-left:30px; " id="Daily" value=<%=daily %> readonly/>
                            </div>
                            <div class="group">
                                <label>
                                <input type="radio" name="passes" value="Monthly" id="monthly" >Monthly
                                <input type="text" name="Monthly" style="margin-left:10px; " id="Monthly" value=<%=monthly %> readonly />
                                </label>
                            </div>
                            <div class="group">
                                <input type="radio" name="passes" value="Yearly" id="yearly">Yearly
                                <input type="text" name="Yearly" style="margin-left:24px; " id="Yearly" value=<%=yearly %> readonly/>
                            </div>
                            <div class="group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Submit" />
                            </div>
						</form>
                        </div>

                </fieldset>
                </div>
        </section>

        </div>
</body>

</html>