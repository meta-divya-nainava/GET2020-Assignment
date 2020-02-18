<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/signup" var="userActionUrl" />
<<!DOCTYPE spring:url PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div class="container">
<fieldset>
<legend style="margin: auto;"> Add details</legend>
<div class="registration-content">
	<form:form modelAttribute="student" action="${userActionUrl}">

		<form:errors />
		<form:hidden path="id"/>
		<div class="group">
			<form:input path="firstName" type="text" 
				id="exampleInputFirstName" placeholder="Enter first name" />
				<br>
			<form:errors path="firstName" style="color:red" />
		</div>
		<div  class="group">
			<form:input path="lastName" type="text" 
				id="exampleInputLastName" placeholder="Enter Last name" />
				<br>
			<form:errors path="lastName" cssClass="text-danger" style="color:red"/>
		</div>
		<div  class="group">
			<form:input path="fatherName" type="text" 
				id="exampleInputFatherName" placeholder="Enter father name" />
				<br>
			<form:errors path="fatherName" cssClass="text-danger" style="color:red"/>
		</div>
		<div  class="group">
			<form:input path="email" type="text" 
				id="exampleInputEmail" placeholder="Enter Email" />
				<br>
			<form:errors path="email" cssClass="text-danger" style="color:red" />
		</div>
		<div  class="group">
			<form:input path="std" type="number" 
				id="exampleInputStd" placeholder="Enter Class" />
				<br>
			<form:errors path="std" cssClass="text-danger" style="color:red"/>
		</div>
		<div  class="group">
			<form:input path="age" type="number" 
				id="exampleInputAge" placeholder="Enter age" />
				<br>
			<form:errors path="age" cssClass="text-danger" style="color:red" />
		</div>
		<button type="submit" >Submit</button>		
	
	</form:form>
	</div>
	</fieldset>
	</div>
	</body>
	</html>