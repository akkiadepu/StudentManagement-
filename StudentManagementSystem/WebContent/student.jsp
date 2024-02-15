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
	<form  method="post" action="studReg" >
	Id:<input type="text" name="id" /><br><br>
	Name:<input type="text" name="name"/><br><br>
	Email:<input type="text" name="email"/><br/><br/>
	<input type="submit" value="Register">
	<input type="reset" value="celse"> 
	
	</form>
	<br/><br/>
	
	<%
		StudentService studentservice = new StudentService();
			 List<Student>students= studentservice.FindAllStudents();
			
	%>
	<table  border="1" cellspacing="0">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Edit | Delete</th>

		</tr>
	<%
		for(Student student : students){	
	%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getEmail()%></td>
			<td><a href="editStudent.jsp?id=<%=student.getId()%>">edit </a> | <a href="deleteStu?id=<%=student.getId()%>">delete</a></td>
		</tr>
		<%
		}
		%>
		
	</table>


	<a href="Signout"> Sign out</a>
</body>
</html>
<%
	} else {
%>

<jsp:forward page="index.jsp">
	<jsp:param value="invalid way to access" name="msg" />
</jsp:forward>
<%
	//	response.sendRedirect("index.jsp");
	}
%>