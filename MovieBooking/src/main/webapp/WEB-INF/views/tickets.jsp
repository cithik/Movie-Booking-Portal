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
<title>Screens</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(function(){ // this will be called when the DOM is ready
	  $('#quantity').keyup(function() {
	    $("#amount").text($("#quantity").val()*10);
	  });
	});
</script>
</head>
<body>
 <table class="table table-condensed">
 <tr>
	<td><h1>Please check your selection:</h1></td>
</tr>
<springForm:form method="POST" commandName="bs" action="booked">
<tr><td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;<b>Customer Info</b></td></tr>
<tr><td>Customer Name:</td>
<td><label>${bs.customer.firstName}</label></td></tr>
<tr><td>Customer Username:</td>
<td><label>${bs.customer.userName}</label></td></tr>
<tr><td>Customer Phone:</td>
<td><label>${bs.customer.phone}</label></td></tr>
<tr><td><span class="glyphicon glyphicon-film" aria-hidden="true"></span>&nbsp;<b>Movie Info</b></td></tr>
<tr><td>Movie Name:</td>
<td><label>${bs.showtime.movie.name}</label></td></tr>
<tr><td>Movie Cast:</td>
<td><label>${bs.showtime.movie.cast}</label></td></tr>
<tr><td><span class="glyphicon glyphicon-expand" aria-hidden="true"></span>&nbsp;<b>Cinema Info</b></td></tr>
<tr><td>Cinema Name:</td>
<td><label>${bs.showtime.cinema.name}</label></td></tr>
<tr><td>Cinema Address:</td>
<td><label>${bs.showtime.cinema.address}</label></td></tr>
<tr><td>Cinema Phone:</td>
<td><label>${bs.showtime.cinema.phone}</label></td></tr>
<tr><td>Cinema e-Mail:</td>
<td><label>${bs.showtime.cinema.email}</label></td></tr>
<tr><td>Cinema Screen:</td>
<td><label>${bs.showtime.screen.name}</label></td></tr>
<springForm:input type="hidden" path="customer.userName" value="${bs.customer.userName}"/>
<springForm:input type="hidden" path="showtime.showtimeId" value="${bs.showtime.showtimeId}"/>
<tr><td><span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span>&nbsp;<b>Ticket Info</b></td></tr>
 <tr>
    	<td>Quantity:</td>
       	<td><springForm:input path="quantity" id="quantity" /><br></td>
       	<td><springForm:errors path="quantity" cssClass="error" /></td>
</tr>
 <tr>
    	<td>Total:</td>
       	<td><label id="amount"></label><br></td>
</tr>
<tr>
    <td></td><td><b><input type = "submit" name="submit" value="Book Tickets"/></b><br></td>
</tr>
</springForm:form>
<springForm:form method = "GET" action="/moviebooking">
<a href="javascript:;" onclick="parentNode.submit();">Logout</a>
</springForm:form>
</table>
</body>
</html>

