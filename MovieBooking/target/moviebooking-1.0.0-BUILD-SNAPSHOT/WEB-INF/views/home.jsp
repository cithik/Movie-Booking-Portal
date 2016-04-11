<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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
 <table>
 <tr>
	<td><h1>Welcome <c:out value= "${customer.userName}"/> :)</h1></td>
</tr>
<tr><td>
<springForm:form method = "POST" commandName="customer" action="selectmovie" id="bookForm">
<springForm:input type="hidden" path="userName" value="${customer.userName}"/>
<a href="javascript:;" onclick="parentNode.submit();">Book Tickets</a>
</springForm:form>
</td></tr>
<tr><td>
<%-- <springForm:form method = "POST" commandName="customer" action="history" id="historyForm">
<springForm:input type="hidden" path="personId" value="${customer.personId}"/>
<a href="javascript:;" onclick="parentNode.submit();">Booking History</a>
</springForm:form> --%>
<a href="/moviebooking/history/${customer.personId}">Booking History</a>
</td></tr>
<tr><td>
<springForm:form method = "POST" commandName="customer" action="rateBooking" id="rateForm">
<springForm:input type="hidden" path="personId" value="${customer.personId}"/>
<a href="javascript:;" onclick="parentNode.submit();">Rate Booking</a>
</springForm:form>
<form method = "POST" action="movieRating" name="comments" id="commentsForm">
 <input type="hidden"  value="${customer.personId}"/> 
<a href="javascript:;" onclick="parentNode.submit();">View Movie Comments</a>
</form>
<springForm:form method = "GET" action="/moviebooking">
<a href="javascript:;" onclick="parentNode.submit();">Logout</a>
</springForm:form>
</td></tr>
</table>
</body>
</html>

