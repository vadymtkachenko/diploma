<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="style.css">
		<title>Hotel</title>

		<script type="text/javascript">
			function add() {
				window.location.href ='/AddClient';
			}
		</script>
	</head>
	<body>
		<div class="wrapper">
			<div class="header">
				<div class="logo"><a href="">Elat<span class="black">Hotel</span><span class="gray">System</span></a><p>The best program</p></div>
				<ul class="nav">
					<li><a href="#" class="active">Clients</a></li>
					<li><a href="/roomsList">Rooms</a></li>
					<li><a href="/bookingsList">Bookings</a></li>
					<%--<li><a href="#">Work</a></li>--%>
					<%--<li><a href="#">News</a></li>--%>
					<%--<li><a href="#">Contacts</a></li>--%>
				</ul>
			</div>
			<div class="content">
				<div class="main">
					<!--Таблица-->
					<h2>GUESTS</h2>

					<table class="bordered">
						<thead>
						<tr>
							<th>#</th>
							<th >ID</th>
							<th>Name</th>
							<th>Surname</th>
							<th>With</th>
							<th>Telephone</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${clients}" var="client" varStatus="status" >
							<tr>
								<td>${status.index + 1}</td>
								<td>${client.id}</td>
								<td>${client.name}</td>
								<td>${client.surname}</td>
								<td>${client.with}</td>
								<td>${client.telephone}</td>
								<td><a href="/clientEdit?id=${client.id}">Edit</a></td>
								<td><a href="/clientDelete?id=${client.id}">Delete</a></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
							<button  onclick="add()" type="button">Add Client</button>
				</div>
			</div>
			<div class="footer">
				<p>&copy; Designed by Vadim Tkachenko</p>
			</div>
		</div>
	</body>
</html>