<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Hotel</title>
    <%--<script type="text/javascript">--%>
        <%--function cancel() {--%>
            <%--window.location.href = '/roomsList';--%>
        <%--}--%>
    <%--</script>--%>
    <script src="/validate.js"></script>
</head>
<body>
<div class="wrapper">
    <div class="header">
        <div class="logo"><a href="">Elat<span class="black">Hotel</span><span class="gray">System</span></a><p>The best program</p></div>
        <ul class="nav">
            <li><a class="active">Adding new Formation</a></li>
            <%--<li><a href="#">About</a></li>--%>
            <%--<li><a href="#">Blogs</a></li>--%>
            <%--<li><a href="#">Work</a></li>--%>
            <%--<li><a href="#">News</a></li>--%>
            <%--<li><a href="#">Contacts</a></li>--%>
        </ul>
    </div>
    <div class="content">
        <div class="main">
            <H1>${pageTitle}</H1><div id="Error"></div>
            <br>
            <br>
            <form name="formation"  method="POST">
                <table>
                    <tr>
                        <td width="100">Name</td>
                        <td width="200">
                            <input type="hidden" name="id" value="${formation.id}">
                            <input name="name" value="${formation.name}"/>
                        </td>
                        <td width="600">
                            <div id="NameError"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>Surname</td>
                        <td><input name="surname" value="${formation.surname}"/></td>
                        <td width="600">
                            <div id="SurnameError"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>Number</td>
                        <td><input name="number" value="${formation.number}"/></td>
                        <td width="600">
                            <div id="WithError"></div>
                        </td>
                    </tr>

                    <tr>
                        <td>DayIN</td>
                        <td><input name="DayIN" value="${formation.dayIN}"/></td>
                    </tr>
                    <tr>
                        <td>DayOUT</td>
                        <td><input name="DayOUT" value="${formation.dayOUT}"/></td>
                    </tr>
                    <tr>
                        <td>Telephone</td>
                        <td><input name="telephone" value="${formation.telephone}"/></td>
                        <td width="600">
                            <div id="TelephoneError"></div>
                        </td>
                    </tr>
                    <tr>
                        <%--<td><input type="button"  onclick="cancel()" value="Назад"/></td>--%>
                        <%--<td><input type="submit" value="Сохранить" /></td>--%>
                    </tr>
                </table>
                <div class="row">
                    <button type="button"onclick="cancel()">Cancel</button>
                    <button type="submit">Save</button>
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