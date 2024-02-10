<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    
    if(session!=null && session.getAttribute("username")!= null) {
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
	<h2>Student management</h2>
	
</body>
</html>
<%

}
    else{
		
    }
%>