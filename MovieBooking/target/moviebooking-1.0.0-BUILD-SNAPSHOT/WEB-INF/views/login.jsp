<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<html>
<head>
<style>
body {
background-color:blueviolet;}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Save Page</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
</head>
<body>
<h1>
	Welcome, Kindly Log In
</h1>
 <table>
<springForm:form method = "POST" commandName="customerLogin" action="authenticate">
         <tr>
              <td>Enter your User Name:</td>
              <td><springForm:input path="userName"/><br></td>
              <td><springForm:errors path="userName" cssClass="error" /></td>
         </tr>
         <tr>
             <td>Enter Your Password:</td>
             <td><springForm:password path="password"/><br></td>
             <td><springForm:errors path="password" cssClass="error" /></td>
         </tr>
         <tr>
             <td><input type = "submit" name="submit" value="Member Login"/><br></td>
         </tr>
</springForm:form>

	<springForm:form method = "POST" action="registration">
         <tr>
             <td><input type = "submit" name="submit" value="New User?"/><br></td>
         </tr>
</springForm:form>
</table>
</body>
</html>

