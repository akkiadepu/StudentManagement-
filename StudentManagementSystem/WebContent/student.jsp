<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (session != null && session.getAttribute("username") != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student JSP</title>
</head>
<body>
	<h2>Student management system 1</h2>

</body>
</html>
<%
	} else {
		response.sendRedirect("index.jsp");
	}
%>