<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import = "model.Film" %>
 <%@ page import = "model.FilmDAO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT FILM</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
<link rel="stylesheet"
      href="./css/style2css.css"
      type="text/css"/>

 <script type="text/javascript">
 $(document).ready(function() {
			var form = $('#form3');
			
			form.submit(function (e) {
			 e.preventDefault();
			$.ajax({
			type: form.attr('method'),
			url: form.attr('action'),
			data: form.serialize(),
			success: function (data) {
			var result=data;
			$('.result').text(result);
			}
			});
			 
			return false;
			});
			
			
			
			
			
 });
			</script>
</head>
<body>

<%
String id  = request.getParameter("edit");

FilmDAO fd = new FilmDAO();

fd.getFilmByID(id);
Film f = new Film();
f = fd.getFilmByID(id);


%>
<h1 class = "head"> Editing  film: <%=f.getTitle() %></h1>
<a href ="Filmeditjsp.jsp">GO BACK</a>
<form action="./updatefilm" method = "get" name = "form3" id = "form3">
	<table border = "1" cellpadding="5">
	<tr>
	<th>ID</th>
	<th>TITLE</th>
	<th>YEAR</th>
	<th>DIRECTOR</th>
	<th>STARS</th>
	<th>REVIEWS</th>
	<th>ACTION</th>
	</tr>
		<tr>
			<td>
			<input type ="text" name = "id" value="<%=f.getId()  %>" readonly>
			</td>
			<td>
			<input type = "text" name  = "title" value = "<%=f.getTitle()%>">
			</td>
			<td>
			<input type = "text" name = "year" value="<%= f.getYear()%>">
			</td>
			<td>
			<input type = "text" name = "director" value="<%=f.getDirector() %>">
			</td>
			<td>
			<input type = "text" name = "stars" value="<%=f.getStars() %>">
			</td>
			<td>
			
			<textarea name = "reviews" id="reviews" rows="6" cols="60"><%=f.getReview() %></textarea>
			</td>
			<td>
			
			<input type = "submit" value="UPDATE">
			
			
			</td>
			
		</tr>
		
		
	
</table>
</form>



<div class ="result"></div>

</body>
</html>