<%@page import="com.EAD3.SetConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="style.css">
<script type="text/javascript">
function vehicleNameValidate() {
    vecName = document.getElementById('vecname').value;
    var pattern = /^[a-zA-Z]{1,}\s{0,}[a-zA-Z]{0,}$/;
    return pattern.test(vecName);
}

function VehicleNumberValidate() {
    vecNumber = document.getElementById('vecnumber').value;
    var numPattern = /^[0-9]{4}$/;
    return numPattern.test(vecNumber);
}
function vehicleRegister() {
	console.log("aaya");
    var flag = 1;
    if (!vehicleNameValidate()) {
        document.getElementById("vecNameAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("vecNameAlert").style.display = "none";
    }
    if (!VehicleNumberValidate()) {
        document.getElementById("vecNumberAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("vecNumberAlert").style.display = "none";
    }
    if (flag == 0) {
        return false;
    } else {
        return true;
       // changeCurrency();*/
    }
}
</script>
</head>
<body>
	<%
		int Id=(int)request.getAttribute("empId");
		System.out.println(Id);
		request.setAttribute("Id", Id);
		HttpSession session1= request.getSession();
		session1.setAttribute("userId", Id);
	%>
<div class="main">

        <section class="register">
            <div class="container">
                <fieldset>
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Vehicle Registration Form</legend>
                    <div class="registration-content">
                        <form  id="registrationform1" class="registration-form" action="passDetail.jsp" method="Post">
                            <div class="group">
                                <input type="text" class="form-input" name="vecEmpId" id="employeeId" readonly value=<%=Id%>>
                            </div>
                            <div class="group">
                                <input type="text" class="form-input" name="vecName" id="vecname" placeholder="Vehicle Name" />
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
                                <input type="text" class="form-input" name="vecNumber" id="vecnumber"  maxlength="4" placeholder="Enter vehicle number">
                                <p id="vecNumberAlert" style="font-size:small; font-weight: 500; color:rgb(56, 54, 54); padding-bottom:-20px; margin-bottom: 1px;">Vehicle number should be of length 4.</p>
                            </div>

                            <div class="group">
                                <textarea placeholder="describe vehicle identifications" class="form-input" name="identification"></textarea>
                            </div>
                            <div class="group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Get Passes" onclick=" return  vehicleRegister()"  />
                            </div>

                      </form>
                  
                        </div>

                </fieldset>
                </div>
        </section>

        </div>
      
</body>
</html>


