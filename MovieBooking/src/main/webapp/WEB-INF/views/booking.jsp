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
function getImage(titel) { 
	$.ajax({ 
	    type: "GET",
	    dataType: "json",
	    url: "http://www.omdbapi.com/?t="+$('#movie option:selected').text(),
	    success: function(data){
	    	$('#imdbRating').text("imdbRating: "+data.imdbRating);
	    	$('#Runtime').text("Runtime: "+data.Runtime);
	    	$('#movie_poster').attr("src",data.Poster);
	    },
	    async:false,
	    error: function() {
	    	$('#movie_poster').attr("src",'');
	    }
	});
	}
function onMovieChange(val) {
	this.getImage();
	$('#time').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar.movie.movieId}" == $('#movie').val()){
        	 $('#time').append($('<option>', { 
                 value: "${listVar}",
                 text : "${listVar}" 
             })); 
		}
    </c:forEach>
    $('#screen').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar.movie.movieId}" == $('#movie').val()){
        	 $('#screen').append($('<option>', { 
                 value: "${listVar.screen.screenId}",
                 text : "${listVar.screen}" 
             })); 
		}
    </c:forEach>
    $('#cinema').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar.movie.movieId}" == $('#movie').val()){
        	 $('#cinema').append($('<option>', { 
                 value: "${listVar.cinema.cinemaId}",
                 text : "${listVar.cinema}" 
             })); 
		}
    </c:forEach>
};
function onCinemaChange(val) {
	$('#time').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar.cinema.cinemaId}" == $('#cinema').val()){
        	 $('#time').append($('<option>', { 
                 value: "${listVar}",
                 text : "${listVar}" 
             })); 
		}
    </c:forEach>
    $('#screen').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar.cinema.cinemaId}" == $('#cinema').val()){
        	 $('#screen').append($('<option>', { 
                 value: "${listVar.screen}",
                 text : "${listVar.screen.screenId}" 
             })); 
		}
    </c:forEach>
    $('#movie').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar.cinema.cinemaId}" == $('#cinema').val()){
        	 $('#movie').append($('<option>', { 
                 value: "${listVar.cinema.cinemaId}",
                 text : "${listVar.cinema}" 
             })); 
		}
    </c:forEach>
};
function onTimeChange(val) {
	$('#cinema').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar}" == $('#time').val()){
        	 $('#cinema').append($('<option>', { 
                 value: "${listVar.cinema.cinemaId}",
                 text : "${listVar.cinema}" 
             })); 
		}
    </c:forEach>
    $('#screen').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
			if("${listVar}" == $('#time').val()){
        	 $('#screen').append($('<option>', { 
                 value: "${listVar.screen}",
                 text : "${listVar.screen.screenId}" 
             })); 
		}
    </c:forEach>
    $('#movie').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
			if("${listVar}" == $('#time').val()){
        	 $('#movie').append($('<option>', { 
                 value: "${listVar.movie.movieId}",
                 text : "${listVar.movie}" 
             })); 
		}
    </c:forEach>
};
function onScreenChange(val) {
	$('#cinema').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar.screen.screenId}" == $('#screen').val()){
        	 $('#cinema').append($('<option>', { 
                 value: "${listVar.cinema.cinemaId}",
                 text : "${listVar.cinema}" 
             })); 
		}
    </c:forEach>
    $('#time').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar.screen.screenId}" == $('#screen').val()){
        	 $('#time').append($('<option>', { 
                 value: "${listVar.screen}",
                 text : "${listVar.screen.screenId}" 
             })); 
		}
    </c:forEach>
    $('#movie').empty();
	<c:forEach var="listVar" items="${mp.showtimes}">
		if("${listVar.screen.screenId}" == $('#screen').val()){
        	 $('#movie').append($('<option>', { 
                 value: "${listVar.movie.movieId}",
                 text : "${listVar.movie}" 
             })); 
		}
    </c:forEach>
};
</script>
</head>
<body>
	<h1>Please select your preference:</h1>
	<table>
		<springForm:form method="POST" commandName="mp" action="booktickets">
		<springForm:input type="hidden" path="userName" value="${userName}"/>
			<tr>
				<td>Select a Movie:</td>
				<td><springForm:select id ="movie" path="up.movieId" onchange="onMovieChange(this);">
				<springForm:option value="NONE" label="--- Select ---" />
						<c:forEach var="listVar" items="${mp.showtimes}">
							<springForm:option value="${listVar.movie.movieId}"
								label="${listVar.movie}"></springForm:option>
						</c:forEach>
					</springForm:select></td>
			</tr>
			<tr>
				<td>Select a time:</td>
				<td><springForm:select id ="time" path="up.time" onchange="onTimeChange(this);">
						<c:forEach var="listVar" items="${mp.showtimes}">
							<springForm:option value="${listVar}" label="${listVar}"></springForm:option>
						</c:forEach>
					</springForm:select></td>
			</tr>
			<tr>
				<td>Select a Cinema:</td>
				<td><springForm:select id ="cinema" path="up.cinemaId" onchange="onCinemaChange(this);">
						<c:forEach var="listVar" items="${mp.showtimes}">
							<springForm:option value="${listVar.cinema.cinemaId}"
								label="${listVar.cinema}"></springForm:option>
						</c:forEach>
					</springForm:select></td>
			</tr>
			<tr>
				<td>Select a Screen:</td>
				<td><springForm:select id ="screen" path="up.screenId" onchange="onScreenChange(this);">
						<c:forEach var="listVar" items="${mp.showtimes}">
							<springForm:option value="${listVar.screen.screenId}"
								label="${listVar.screen}"></springForm:option>
						</c:forEach>
					</springForm:select></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Book Tickets" /><br></td>
			</tr>
		</springForm:form>
<springForm:form method = "GET" action="/moviebooking">
<a href="javascript:;" onclick="parentNode.submit();">Logout</a>
</springForm:form>
	</table>
	<table>
	<tr><td><div id="imdbRating"></div></td></tr>
	<tr><td><div id="Runtime"></div></td></tr>
	<tr><td><img id="movie_poster"></img></td></tr>
	</table>
</body>
</html>

