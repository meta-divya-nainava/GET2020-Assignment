<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="style.css">
    <title>Metacube Parking System</title>


    <script src="javascript.js"></script>


</head>

<body>
<header >
<div>
<ul>
  <li><a href="/logout" style="float: left"> logOut</a></li>
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
                    
                    <div class="registration-content">
                        <table id="detailTable" class="registration-form">
                                    <c:forEach items="${friendList}" var="friendObject">


 		<tr>   <td>${friendObject.empId}</td>
        <td>${friendObject.name}</td>
         <td><a href="/home/${friendObject.empId}" >Go to profile</a> </td>
      </tr>

</c:forEach>
                         
                        </table>
                        </div>

                </fieldset>
                </div>
        </section>

        </div>
</body>

</html>
