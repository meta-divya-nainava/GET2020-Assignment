<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*,com.EAD3.DatabaseQuery" %>
        <%
        			DatabaseQuery queryObject=new DatabaseQuery();
  					String vecEmpId=request.getParameter(request.getParameter("vecEmpId"));
        			String vecName=request.getParameter(request.getParameter("vecName"));
        			String type=request.getParameter(request.getParameter("type"));
        			String identification=request.getParameter(request.getParameter("identification"));
        			String vecNumber=request.getParameter(request.getParameter("vecNumber"));
        			ResultSet rs1=queryObject.insertVehicleData(vecEmpId, vecName, type, identification, vecNumber);
                	rs1.next();
					int daily=rs1.getInt(2);
					int monthly=rs1.getInt(3);
					int yearly=rs1.getInt(4);
  				%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="style.css">
    <title>Metacube Parking System</title>


    <script src="javascript.js"></script>


</head>

<body>
    <div class="main">

        <section class="register">
            <div class="container">
                <fieldset>
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Passes</legend>
                    <div class="registration-content">
                        <form class="registration-form" id="registrationform2" action="PassDetailInsert.jsp" method="Post">
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
