
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/vehicle" var="userActionUrl2" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="/style.css">
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
    }
}
</script>
</head>
<body>
<div class="main">

        <section class="register">
            <div class="container">
                <fieldset>
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Vehicle Registration Form</legend>
                    <div class="registration-content">
                        <form:form modelAttribute="vehicleObject" action="${userActionUrl2}" id="registrationform1" class="registration-form">
                            <div class="group">
                                <form:input path="empId" type="text" class="form-input" name="vecEmpId" id="employeeId"  value="${empId}" />
                            </div>
                            <div class="group">
                                <form:input path="vehicleName" type="text" class="form-input" name="vecName" id="vecname" placeholder="Vehicle Name" />
                                <form:errors path="vehicleName" cssClass="text-danger" style="color:red" />
                            </div>
                            <div class="group">
            
                                <form:select path="vehicleType" class="form-input" id="typeOfVehicle" name="type">
                                        <form:option class="form-input" value="motorcycle">MotorCycle</form:option>
                                        <form:option  class="form-input" value="cycle"  >Cycle</form:option>
                                        <form:option class="form-input" value="fourWheelers">Four-Wheelers</form:option>
                                      </form:select>
                            </div>
                            <div class="group">
                                <form:input path="vehicleNumber" type="text" class="form-input" name="vecNumber" id="vecnumber"  maxlength="4" placeholder="Enter vehicle number"/>
                               <form:errors path="vehicleNumber" cssClass="text-danger" style="color:red" />
                            </div>

                            <div class="group">
                                <form:textarea path="identification" placeholder="describe vehicle identifications" class="form-input" name="identification"></form:textarea>
                                <form:errors path="identification" cssClass="text-danger" style="color:red" />
                            </div>
                            <div class="group">
                                <button type="submit" name="submit" id="submit" class="form-submit" value="Get Passes" onsubmit=" return vehicleRegister()" >Submit</button>
                            </div>

                      </form:form>
                  
                        </div>

                </fieldset>
                </div>
        </section>

        </div>
      
</body>
</html>


