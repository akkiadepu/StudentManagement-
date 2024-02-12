<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sms</title>
</head>
<body>
	<h2>Student management system</h2>
	<h3>Login</h3>
	<%
	if(session.getAttribute("msg")!= null){
		%>
		<span style="color: red">
		<%=session.getAttribute("msg") %>
		</span>
		<% 
		session.removeAttribute("msg");
	}
	%>
	<%
	if(request.getAttribute("msg")!= null){
		%>
		<span style="color: orange;">
		<%=request.getAttribute("msg") %>
		</span>
		<% 
		request.removeAttribute("msg");
	}
	%>
	
	
	
	<form action="ls" method="post">
	UserName: <input type="text" name="username"/><br><br>
	Password: <input type="password" name="password"/><br><br>
	<input type="submit" value="login"><br><br>
	<input type="reset" value="cancel"><br><br>
	
	</form>

</body>
</html>