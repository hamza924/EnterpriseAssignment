<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "model.Film" %>
 <%@ page import = "model.FilmDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete film</title>
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
			//$('.result').text(result);
			alert(result);
			}
			});
			 
			return false;
			});
			
			
			
			
			
 });
			</script>
</head>
<body>

<%
String id  = request.getParameter("delete");

FilmDAO fd = new FilmDAO();

fd.getFilmByID(id);
Film f = new Film();
f = fd.getFilmByID(id);


%>
<h1 class = "head">DELETING : <%=f.getTitle() %></h1>
<div class = "formout">
<div class = "innerform">
<form action="./deletefilm?delete=<%=f.getId()  %>" method = "get" name = "form3" id = "form3">
	<table border="1" cellpadding="5">
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
			<%=f.getId() %>
			
			</td>
			<td>
			<%=f.getTitle() %>
			
			</td>
			<td>
			<%=f.getYear() %>
			
			</td>
			<td>
			<%=f.getDirector() %>
			
			</td>
			<td>
			<%=f.getStars() %>
			
			</td>
			<td>
			<%=f.getReview() %>
			
			</td>
			<td>
			
			<input type = "submit" value="DELETE"><br>
			
			
			</td>
			
		</tr>
		
		
	
</table>
</form>
<a href ="Filmeditjsp.jsp">GO BACK</a>
</div>
</div>

<div class ="result"></div>

</body>
</html>