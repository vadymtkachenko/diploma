<%--
  Created by IntelliJ IDEA.
  User: Elat
  Date: 08.04.2017
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
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
            window.location.href ='/AddRoom';
        }
    </script>
    <script type="text/javascript">
        function formations() {
            window.location.href ='/formationsList';
        }
    </script>


</head>
<body>
<div class="wrapper">
    <div class="header">
        <div class="logo"><a href="">Elat<span class="black">Hotel</span><span class="gray">System</span></a><p>The best program</p></div>
        <ul class="nav">
            <li><a href="#" class="active">Rooms</a></li>
            <li><a href="/clientsList">Clients</a></li>
            <li><a href="/bookingsList">Bookings</a></li>
            <%--<li><a href="#">Work</a></li>--%>
            <%--<li><a href="#">News</a></li>--%>
            <%--<li><a href="#">Contacts</a></li>--%>
        </ul>
    </div>
    <div class="content">
        <div class="main">
            <!--Таблица-->
            <h2>ROOMS</h2>

            <table class="bordered">
                <thead>
                <tr>
                    <th>#</th>
                    <th >ID</th>
                    <th>Number</th>
                    <th>Stage</th>
                    <th>Type</th>
                    <th>Price</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${rooms}" var="room" varStatus="status" >
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${room.id}</td>
                        <td>${room.number}</td>
                        <td>${room.stage}</td>
                        <td>${room.type}</td>
                        <td>${room.price}</td>
                        <td><a href="/roomsEdit?id=${room.id}">Edit</a></td>
                        <td><a href="/roomDelete?id=${room.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button  onclick="add()" type="button">Add Room</button>
            <button  onclick="formations()" type="button">Formations</button>
        </div>
    </div>
    <div class="content" >
        <div class="main">
            <H1>${pageTitle}</H1><div id="Error"></div>
            <br>
            <br>
            <form name="room"  method="POST">
                <table>
                    <tr>
                        <td width="100">Until</td>
                        <td width="200">
                            <input name="until" />
                        </td>

                    </tr>
                    <tr>
                        <td>To</td>
                        <td><input name="to" /></td>
                    </tr>
                    <tr>
                        <%--<td><input type="button"  onclick="cancel()" value="Назад"/></td>--%>
                        <%--<td><input type="submit" value="Сохранить" /></td>--%>
                    </tr>
                </table>
                <div class="row">
                    <button  type="submit">Show Free Numbers</button>
                </div>
            </form>
        </div>
    </div>
    <div class="footer">
        <p>&copy; Designed by Vadim Tkachenko</p>
    </div>
</div>
</body>
</html>
