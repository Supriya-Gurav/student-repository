 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ page isELIgnored = "false" %>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Page..!</title>
</head>
<body>	

		<a href="/spring-webapp1/">HOME</a>
		<h1>Registration Page...</h1>

		<c:out value="${result}"></c:out><br><br>
	<form:form modelAttribute="empBean" action="/spring-webapp1/save">
			Enter EmpId : <form:input path="empId"/> <br><br>
			Enter EmpName : <form:input path="empName"/> <br><br>
			Enter EmpEmail : <form:input path="empEmail"/> <br><br>
			Enter EmpSalary : <form:input path="empSalary"/> <br><br>
			Enter EmpAge : <form:input path="empAge"/> <br><br>
			Enter EmpAddress : <form:input path="empAddress"/> <br><br>
			<input type="submit" name="save" value="save">
			
	</form:form>


</body>
</html>