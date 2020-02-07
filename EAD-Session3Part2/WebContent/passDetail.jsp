<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*, com.EAD3.SetConnection" %>
        <%
  
  					Connection con=new SetConnection().setConnection();
					PreparedStatement st= (PreparedStatement) con.prepareStatement("insert into vehicleData (empId,vehicleName,vehicleType,identification,vehicleNumber)values(?,?,?,?,?)");
	
					st.setInt(1,Integer.parseInt(request.getParameter("vecEmpId")));
					System.out.println(request.getParameter("vecName"));
					st.setString(2,request.getParameter("vecName"));
					st.setString(3,request.getParameter("type"));
					st.setString(4,request.getParameter("identification"));
					st.setString(5,request.getParameter("vecNumber"));
					st.executeUpdate();
					st.close();
					java.sql.Statement state1= con.createStatement();
					String query1= "select * from planData where vehicleType='"+request.getParameter("type")+"'";
					ResultSet rs1= state1.executeQuery(query1);
					rs1.next();
					int daily=rs1.getInt(2);
					int monthly=rs1.getInt(3);
					int yearly=rs1.getInt(4);
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
