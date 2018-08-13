<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop Stop Book Store</title>
<style type="text/css" colour="white">
* {
	box-sizing: border-box;
	text-color: white;
}

table {
	width: 80%;
	border-spacing: 5px;
	border-collapse: collapse;
	
}

th, td {
	text-align: left;
	padding: 8px;
}

body {
font-weight: bold;
	color: black;
	background-repeat: no-repeat, repeat;
	font-family: 'Roboto', sans-serif;
}
</style>

</head>
<body background="img/Bookshelf.png">

	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div align="center" text-align="justify;" text-align-last="justify;">
		<h2><i>Book Archive</i></h2>

		<jstl:if test="${requestScope.book.size() > 0 }">
			<table>
				<tr>
					<th></th>
					<th>Book Name</th>
					<th>Author Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
					<th></th>
				</tr>
				<!-- Displaying the list of books available in the store 
				Initial count is zero for all books-->
				<jstl:forEach var="book" items="${requestScope.book}">
					<tr>

						<td><img src="img/${book.bookImg}" width=50px height="50px" /></td>
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
