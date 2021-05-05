<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import = "model.FilmDAO" %>
<%@ page import = "model.Film" %>
<%@ page import ="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
<link rel="stylesheet"
      href="./css/style2css.css"
      type="text/css"/>
      

 

</head>
<body>
<%
FilmDAO FD = new FilmDAO();
ArrayList<Film> film = FD.getAllFilms();

request.setAttribute("film",film);



%>
<h1 class = "head">EDIT FILMS</h1>

<ul>
		<list>
		<a href = "index.html">GO BACK</a>
		
		</list>
		
		</ul>

<form action ="./editfilm.jsp" method="get">
<table border = "1" cellpadding="5" id = "form3">
	<tr>
	<th>ID</th>
	<th>Title</th>
	<th>Year</th>
	<th>Director</th>
	<th>Stars</th>
	<th>Reviews</th>
	<th>ACTIONS</th>
	
	</tr>
		
		<c:forEach var="film" items="${film}">
		<tr>
		<td>
		
		
		<c:out value="${film.getId() }"></c:out>
		
		
		</td>
		<td>
		<c:out value="${film.getTitle() }"></c:out>
		</td>
		
		
		
		<td>
		<c:out value="${film.getYear() }"></c:out>
		
		</td>
		<td>
		<c:out value="${film.getDirector()}"></c:out>
		</td>
		
		<td>
		<c:out value="${film.getStars() }"></c:out>
		</td>
		
		<td>
		<c:out value="${film.getReview() }"></c:out>
		</td>
	
		<td>
		<a href="./editfilm.jsp?edit=${film.getId() }" class = "edit">EDIT</a><br><br>
		
		<a href="./delete.jsp?delete=${film.getId()}" class = "link">DELETE</a>
		
		</td>
	
	
	
		</tr>
		</c:forEach>
		
		
		
		


</table>

</form>
</body>
</html>