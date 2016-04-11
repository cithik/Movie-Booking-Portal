<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
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
<springForm:form method="POST" commandName="customer" action="registered">
     <table>
         <tr>
              <td>User Name:</td>
              <td><springForm:input path="userName"/><br></td>
              <td><springForm:errors path="userName" cssClass="error" /></td>
         </tr>
         <tr>
             <td>Password:</td>
             <td><springForm:password path="password"/><br></td>
             <td><springForm:errors path="password" cssClass="error" /></td>
         </tr>
         <tr>
              <td>First Name:</td>
              <td><springForm:input path="firstName"/><br></td>
              <td><springForm:errors path="firstName" cssClass="error" /></td>
         </tr>
         <tr>
             <td>Last Name:</td>
             <td><springForm:input path="lastName"/><br></td>
             <td><springForm:errors path="lastName" cssClass="error" /></td>
         </tr>
         <tr>
             <td>E-mail:</td>
             <td><springForm:input path="email"/><br></td>
             <td><springForm:errors path="email" cssClass="error" /></td>
         </tr>
         <tr>
             <td>Phone:</td>
             <td><springForm:input path="phone"/><br></td>
             <td><springForm:errors path="phone" cssClass="error" /></td>
         </tr>
         <tr>
             <td>Date of Birth:</td>
             <td><springForm:input path="dob" placeholder="MM/dd/yyyy"/><br></td>
             <td><springForm:errors path="dob" cssClass="error" /></td>
         </tr>
         <tr>
             <td><input type = "submit" name="submit" value="Register"/><br></td>
         </tr>
    </table>
</springForm:form>
</body>
</html>

