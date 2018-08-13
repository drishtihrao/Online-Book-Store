<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart List</title>
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
	<div align="right">
		<a href="cart.app"></a>()
	</div>
	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>

	<div class="container mb-4" align="center">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-striped">

						<tbody>
							<jstl:if test="${sessionScope.cartItems.size() > 0 }">
								<thead>
									<tr>
										<th scope="col"></th>
										<th scope="col">Name</th>
										<th scope="col">Author</th>
										<th scope="col">Description</th>
										<th scope="col">Price</th>
										<th scope="col" class="text-right">Quantity</th>
										<th scope="col" class="text-right"></th>
										<th></th>
									</tr>
								</thead>
								<jstl:set var="amount" value="${0}" scope="page" />
								<jstl:forEach var="addedbooks" items="${sessionScope.cartItems}">
									<tr>
										<td><img src="img/${addedbooks.bookImg}" width=50px
											height="50px" /></td>




										<td>${addedbooks.bookName}</td>
										<td>${addedbooks.authorName}</td>
										<td>${addedbooks.description}</td>
										<td>${addedbooks.price}</td>
										<td>${addedbooks.bookCount}</td>



										<td style="display: none;">€</td>
										<td class="text-right">Rs.
											${addedbooks.price*addedbooks.bookCount}</td>
										<jstl:set var="amount"
											value="${amount =amount+ addedbooks.price*addedbooks.bookCount}"
											scope="page" />
										<td class="text-right">
										<td><a
											href="delete.app?bookName=${addedbooks.bookName}&authorName=${addedbooks.authorName}&description=${addedbooks.description}&price=${addedbooks.price}&bookCount=${addedbooks.bookCount}&bookImg=">Delete</a></td>


									</tr>
									<!-- Calculating the total price of each item and the overall cost -->
								</jstl:forEach>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td><strong>Total</strong></td>
									<td class="text-right"><strong>Rs. ${amount}</strong></td>
									<td></td>
								</tr>

	<!-- Displaying the message of empty cart if the number of cart items is zero  -->
							</jstl:if>
							<jstl:if test="${sessionScope.cartItems.size() == 0 }">
								<section class="jumbotron text-center">
									<div class="container">
										<h1 class="jumbotron-heading">Your Cart is Empty</h1>
									</div>
								</section>
							</jstl:if>
						</tbody>
					</table>
				</div>
			</div>
			<br>

			<div class="col mb-4">
				<div class="row">
					<div class="col-sm-15  col-md-9">

						<a class="btn btn-block btn-light" href="refresh.app">Continue
							Shopping</a>
					</div>
					<br>
					<div class="col-sm-12 col-md-9 text-right">
						<button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>