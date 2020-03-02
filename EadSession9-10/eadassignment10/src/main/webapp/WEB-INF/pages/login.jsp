<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/login" var="userActionUrl" />
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="style.css">
    <title>Metacube Parking System</title>


    <script src="javascript.js"></script>


</head>

<body>
    <div class="main">
    <h5 style="color:red">${message}</h5>

        <section class="register">
            <div class="container">
                <fieldset>
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Register for Metacube parking</legend>
                    <div class="registration-content">
                        <form:form modelAttribute="userObject" action="${userActionUrl}" id="registrationform" class="registration-form">
                            <div class="group">
                                <form:input path="userEmail" type="email" class="form-input" name="loginEmail" id="email" placeholder="Your Email"/>
                               <form:errors path="userEmail" cssClass="text-danger" />
                            </div>
                            <div class="group">
                               <form:input path="password" type="password" class="form-input" name="loginPassword" id="password" placeholder="Password" />
            					<form:errors path="password" cssClass="text-danger" />
                            </div>

                            <div class="group">
                                <input type="submit" name="submit" id="submit" class="form-submit"  />
                            </div>
                            <p class="loginhere" style="color:rgb(56, 54, 54);">
                                create an account . <a href="/signup" class="register-link">Sign-up here</a>
                            </p>
                        </form:form>
              		  </div>

                </fieldset>
                </div>
        </section>

        </div>
</body>

</html>