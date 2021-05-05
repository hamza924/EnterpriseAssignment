<%@ page import = "java.util.ArrayList"%>

<%@ page import = "model.Film" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import = "com.google.gson.Gson" %>
<%@ page language="java" contentType="application/json; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


<%

ArrayList<Film> films = (ArrayList<Film>) request.getAttribute("films");

Gson gson = new Gson();
String jsonResult;
		
jsonResult = gson.toJson(films);
out.println(jsonResult);
%>
