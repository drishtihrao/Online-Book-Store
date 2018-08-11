<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop Stop Cart</title>
</head>
<body>
<div align = "center">
		<h1>Cart</h1>
		<table>
				<tr>
					<th>Books</th>
					<th>Book Count</th>
				</tr>
				
				<jstl:forEach var="book" items="${requestScope.books}">
					<tr>
					${requestScope.books}
						<td>${book.empId}</td>
						<td>${book.empName}</td>
						<td><a href="delete.app?bookName=${employee.bookName}">Delete</a></td>
					</tr>
				</jstl:forEach>
			</table>

		<jstl:if test="${requestScope.books.size() == 0 }">
			<h4>No Book Found!</h4>
		</jstl:if>
</div>
</body>
</html>