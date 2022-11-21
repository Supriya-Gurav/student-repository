<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

 <%@ page isELIgnored = "false" %>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Employees.....</title>
</head>
<body>

		<a href="/spring-webapp1/">HOME</a>
		<h1> Show List Of Employees</h1>
		<br><br><br>
		
		<table border="1">
				<thead>
						<th>Emp Id </th>
						<th>Emp Name </th>
						<th>Emp Email </th>
						<th>Emp Salary </th>
						<th>Emp Age </th>
						<th>Emp Address</th>
						<th>Action</th>
							
				</thead>
				
				<tbody>
				 <c:forEach var="emp" items="${empList}">
        	 			<tr>
        	 					<td><c:out value="${emp.empId}"></c:out></td>
								<td><c:out value="${emp.empName}"></c:out></td>
								<td><c:out value="${emp.empEmail}"></c:out></td>
								<td><c:out value="${emp.empSalary}"></c:out></td>
								<td><c:out value="${emp.empAge}"></c:out></td>
								<td><c:out value="${emp.empAddress}"></c:out></td>
								<td>
								<a href="/spring-webapp1/edit_Employee/<c:out value="${emp.empId}">
								</c:out>">EDIT</a> | 
								<a href="/spring-webapp1/delete_Employee/<c:out value="${emp.empId}">
								</c:out>">DELETE</a> 
								</td>
			
        	 			</tr>
      			</c:forEach>
				</tbody>      
		</table>

</body>
</html>