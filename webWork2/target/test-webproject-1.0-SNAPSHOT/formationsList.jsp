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
            <li><a href="#" class="active">Formations</a></li>
            <%--<li><a href="/roomsList">Rooms</a></li>--%>
            <%--<li><a href="#">Blogs</a></li>--%>
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
                    <th>Number</th>
                    <th>Telephone</th>
                    <th>Date IN</th>
                    <th>Date OUT</th>

                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${formations}" var="formation" varStatus="status" >
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${formation.id}</td>
                        <td>${formation.name}</td>
                        <td>${formation.surname}</td>
                        <td>${formation.number}</td>
                        <td>${formation.telephone}</td>
                        <td>${formation.dayIN}</td>
                        <td>${formation.dayOUT}</td>
                        <td><a href="/formationDelete?id=${formation.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%--<button  onclick="add()" type="button">Add Client</button>--%>
        </div>
    </div>
    <div class="footer">
        <p>&copy; Designed by Vadim Tkachenko</p>
    </div>
</div>
</body>
</html>
