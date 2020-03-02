<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/passes" var="userActionUrl3" />
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="/style.css">
    <title>Metacube Parking System</title>


    <script src="/javascript.js"></script>


</head>

<body>
    <div class="main">

        <section class="register">
            <div class="container">
                <fieldset>
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Passes</legend>
                    <div class="registration-content">
                        <form:form modelAttribute="passObject" action="${userActionUrl3}" class="registration-form" id="registrationform2">
                            <div class="group">
                            	<form:radiobutton path="passChoice"  value="daily" class="radio-button" />Daily
                                <form:input path="dailyPrice" type="text" name="Daily" style="margin-left:30px; " id="Daily" value="${planClass.dailyPrice }" />
                                 <form:errors path="passChoice" cssClass="text-danger" style="color:red" />
     
                            </div>
                            <div class="group">
                                <label>
                               <form:radiobutton path="passChoice"  value="monthly" class="radio-button" />Monthly
                                <form:input path="monthlyPrice" type="text" name="Monthly" style="margin-left:10px; " id="Monthly" value="${planClass.monthlyPrice }"/>
                                 <form:errors path="passChoice" cssClass="text-danger" style="color:red" />
                                </label>
                            </div>
                            <div class="group">
                               <form:radiobutton path="passChoice"  value="yearly" class="radio-button" />Yearly
                                <form:input path="yearlyPrice" type="text" name="Yearly" style="margin-left:24px; " id="Yearly" value="${planClass.yearlyPrice }"/>
                                 <form:errors path="passChoice" cssClass="text-danger" style="color:red" />
                            </div>
                            <form:errors path="passChoice" cssClass="text-danger" style="color:red" />
                            <div class="group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Submit" />
                            </div>
                            
						</form:form>
                        </div>

                </fieldset>
                </div>
        </section>

        </div>
</body>

</html>
