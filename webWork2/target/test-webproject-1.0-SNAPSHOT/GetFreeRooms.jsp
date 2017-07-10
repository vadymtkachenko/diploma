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
        function cancel() {
            window.location.href = '/roomsList';
        }
    </script>
</head>
<body>
<div class="wrapper">
    <div class="header">
        <div class="logo"><a href="">Elat<span class="black">Hotel</span><span class="gray">System</span></a><p>The best program</p></div>
        <ul class="nav">
            <li><a href="#" class="active">Free Rooms</a></li>
            <li><a href="/clientsList">Clients</a></li>
            <%--<li><a href="#">Blogs</a></li>--%>
            <%--<li><a href="#">Work</a></li>--%>
            <%--<li><a href="#">News</a></li>--%>
            <%--<li><a href="#">Contacts</a></li>--%>
        </ul>
    </div>
    <div class="content">
        <div class="main" >
            <!--Таблица-->
            <h2>ROOMS</h2>

            <table class="bordered">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Number</th>
                    <th>Type</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${rooms}" var="room" varStatus="status"  >
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${room.number}</td>
                        <td>${room.type}</td>
                        <td>${room.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <button type="button"onclick="cancel()">Set another dates</button>
            </div>
        </div>
    </div>
    <div class="footer">
        <p>&copy; Designed by Vadim Tkachenko</p>
    </div>
</div>
</body>
</html>
