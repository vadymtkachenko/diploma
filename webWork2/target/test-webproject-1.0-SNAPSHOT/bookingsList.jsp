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
            window.location.href ='/AddBooking';
        }
    </script>

</head>
<body>
<div class="wrapper">
    <div class="header">
        <div class="logo"><a href="">Elat<span class="black">Hotel</span><span class="gray">System</span></a><p>The best program</p></div>
        <ul class="nav">
            <li><a href="#" class="active">Bookings</a></li>
            <li><a href="/roomsList">Rooms</a></li>
            <li><a href="/clientsList">Clients</a></li>
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
                    <th>ID</th>
                    <th>Date of booking</th>
                    <th>id of client</th>
                    <th>id of room</th>
                    <th>Date IN</th>
                    <th>Date OUT</th>

                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${bookings}" var="booking" varStatus="status" >
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${booking.id}</td>
                        <td>${booking.dayOfBooking}</td>
                        <td>${booking.clientId}</td>
                        <td>${booking.roomId}</td>
                        <td>${booking.dayIN}</td>
                        <td>${booking.dayOUT}</td>
                        <td><a href="/bookingEdit?id=${booking.id}">Edit</a></td>
                        <td><a href="/bookingDelete?id=${booking.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button  onclick="add()" type="button">Add booking</button>
        </div>
    </div>
    <div class="footer">
        <p>&copy; Designed by Vadim Tkachenko</p>
    </div>
</div>
</body>
</html>
