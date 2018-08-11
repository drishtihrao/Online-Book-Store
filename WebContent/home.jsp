<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop Stop Book Store</title>
<style type="text/css" colour=#FFFFFF>
* {
	
	box-sizing: border-box;
}
table {
	width: 80%;
    border-spacing: 5px;
    background-color: #7D8279;
}

body {

	padding: 10px;
	width: 100%;
	height: 100%;
	margin: 0;
	background-color: #7D8279;
	font-family: 'Roboto', sans-serif;
}
</style>

</head>
<body>

	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div align="center" text-align ="justify;" text-align-last ="justify;">
		<h1>Book Archive</h1>

		<jstl:if test="${requestScope.book.size() > 0 }">
			<table>
				<tr>
					<th></th>
					<th>Book Name</th>
					<th>Author Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Count</th>
					<th></th>
				</tr>
				<jstl:forEach var="book" items="${requestScope.book}">
					<tr>

						<td><img src="img/${book.bookImg}" width=50px
							height="50px" /></td>
						<td>${book.bookName}</td>
						<td>${book.authorName}</td>
						<td><p>${book.description}</p></td>
						<td>${book.price}</td>
						<td>${book.bookCount}</td>



						<td><a
							href="addtocart.app?bookName=${book.bookName}&authorName=${book.authorName}&description=${book.description}&price=${book.price}&bookCount=${book.bookCount}&bookImg=${book.bookImg}">
								Add to Cart</a></td>


					</tr>
				</jstl:forEach>

			</table>
		</jstl:if>
		<jstl:if test="${requestScope.book.size() == 0 }">
			<h4>No Book Found!</h4>
		</jstl:if>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
