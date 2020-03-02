<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/update" var="userActionUrl4" />
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="/style.css">
    <title>Metacube Parking System</title>


    <script src="/javascript.js"></script>


</head>

<body>
<header >
<div>
<ul>
  <li><a href="/logout1" style="float: left"> logout</a></li>
  <li><a href="/update" style="float: left;margin-left: 20px;"> Update Details</a></li>
  <li><a href="/friend" style="float: left;margin-left: 20px;">Show friendList</a></li>
  <li style="float:right"><a class="active" href="/upload"><img src="/image/${imageName}/" width="30%" ></a></li>
</ul>
</div>
</header>
    <div class="main">

        <section class="register">
            <div class="container">
            <br>
                <fieldset>
                    <legend id="formTitle" style="margin: auto; font-size: 20px; font-style: italic; color:  rgb(56, 54, 54);">Register for Metacube parking</legend>
                    <div>${existEmail}</div>
                    <div class="registration-content">
                        <form:form modelAttribute="employeeObject" action="${userActionUrl4}" id="registrationform" class="registration-form" >
                            <div class="group">
                                <form:input path="name" type="text" class="form-input" name="name" id="name" placeholder="Your Name"  />
                                <form:errors path="name" cssClass="text-danger" style="color:red" />
                            </div>
                            <div class="group">
                                <form:radiobutton path="gender"  value="male" class="radio-button" />Male
                                <form:radiobutton path="gender"  value="female" class="radio-button" />Female
                                <br>
                                 <form:errors path="gender" cssClass="text-danger" style="color:red" />
                            </div>
                            <div class="group">
                                <form:input path="contact" type="text" class="form-input" name="contactNo" id="number"  maxlength="10" placeholder="Enter contact number" />
                                <form:errors path="contact" cssClass="text-danger" style="color:red"/>
                            </div>
                            <div class="group">
                                <form:input path="email" type="email" class="form-input" name="email" id="email" placeholder="Your Email"/>
                                <form:errors path="email" cssClass="text-danger" style="color:red" />
                            </div>
                             <div class="group" >
                                <form:select path="typeOfOrg" class="form-input" id="typeOfOrg">
                                        <form:option class="form-input" value="M1">M1</form:option>
                                        <form:option  class="form-input" value="M2" >M2</form:option>
                                        <form:option class="form-input" value="M3">M3</form:option>
                                        <form:option class="form-input" value="M4" >M4</form:option>
                                 </form:select>
                            </div>
                            <div class="group">
                                <form:input path="password" type="password" class="form-input" name="password" id="password" placeholder="Password" onkeyup="isValid()"/>
                                 <form:errors path="password" cssClass="text-danger" style="color:red" />
                            </div>
     
                            <div class="group">
                               
                                <button type="submit" name="submit" id="submit" class="form-submit" value="Register" onsubmit="employeeRegister()">submit </button>
                            </div>
                        </form:form>
                        </div>

                </fieldset>
                </div>
        </section>

        </div>
</body>

</html>