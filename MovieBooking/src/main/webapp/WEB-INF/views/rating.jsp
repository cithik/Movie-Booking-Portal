<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
body {
background-color:blueviolet;}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Selection</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
function onMovieChange(val) {
	<c:forEach var="listVar" items="${booking}">
		if("${listVar.bookingId}" == $('#booking').val()){
			$('#movieName').text("${listVar.showtime.movie.name}"); 
			$('#cinemaName').text("${listVar.showtime.cinema.name}"); 
			$('#screenName').text("${listVar.showtime.screen.name}");
			$('#quantity').text("${listVar.quantity}");
		}
    </c:forEach>
};
</script>
</head>
<body>
	<h1>Please select a booking number:</h1>
	<table>
		<springForm:form method="POST" commandName="bookingRating" action="rated">
			<tr>
				<td>Select a Booking:</td>
				<td><springForm:select id ="booking" path="bookingId" onchange="onMovieChange(this);">
				<springForm:option value="NONE" label="--- Select ---" />
						<c:forEach var="listVar" items="${booking}">
							<springForm:option value="${listVar.bookingId}"
								label="${listVar.bookingId}"></springForm:option>
						</c:forEach>
					</springForm:select></td>
			</tr>
			<tr>
				<td>Movie Rating:</td>
				<td><springForm:select path="movieRating">
						<c:forEach var="i" begin="1" end="5">
							<springForm:option value="${i}"
								label="${i}"></springForm:option>
						</c:forEach>
					</springForm:select></td>
			</tr>
			<tr>
              <td>Movie Comment:</td>
              <td><springForm:textarea path="movieComment"/><br></td>
         	</tr>
         	<tr>
				<td>Screen Rating:</td>
				<td><springForm:select path="screenRating">
						<c:forEach var="i" begin="1" end="5">
							<springForm:option value="${i}"
								label="${i}"></springForm:option>
						</c:forEach>
					</springForm:select></td>
			</tr>
			<tr>
              <td>Screen Comment:</td>
              <td><springForm:textarea path="screenComment"/><br></td>
         	</tr>
         	<tr>
             <td><input type = "submit" name="submit" value="Rate"/><br></td>
         </tr>
		</springForm:form>
<springForm:form method = "GET" action="/moviebooking">
<a href="javascript:;" onclick="parentNode.submit();">Logout</a>
</springForm:form>
	</table>
	<table>
	<tr><td>Movie Name:</td><td><label id="movieName"></label></td></tr>
	<tr><td>Cinema Name:</td><td><label id="cinemaName"></label></td></tr>
	<tr><td>Screen Name:</td><td><label id="screenName"></label></td></tr>
	<tr><td>Quantity:</td><td><label id="quantity"></label></td></tr>
	</table>
</body>
</html>

