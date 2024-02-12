<%@page import="java.util.List"%>
<%@page import="com.codegana.beans.Student"%>
<%@page import="com.codegana.service.StudentService"%>
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
	<%
		StudentService studentservice = new StudentService();
			 List<Student>students= studentservice.FindAllStudents();
			
	%>
	<table  border="1" cellspacing="0">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>

		</tr>
	<%
		for(Student student : students){	
	%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getEmail()%></td>
		</tr>
		<%
		}
		%>
		
	</table>
	<%
		
	%>


</body>
</html>
<%
	} else {
%>

<jsp:forward page="index.jsp">
	<jsp:param value="invalid" name="msg" />
</jsp:forward>
<%
	//	response.sendRedirect("index.jsp");
	}
%>