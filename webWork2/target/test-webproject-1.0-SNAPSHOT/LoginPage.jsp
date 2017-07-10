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
            <%--window.location.href = '/clientsList';--%>
        <%--}--%>
    <%--</script>--%>
    <%--<script src="/validate.js"></script>--%>
</head>
<body>
<div class="wrapper">
    <div class="header">
        <div class="logo"><a href="">Elat<span class="black">Hotel</span><span class="gray">System</span></a><p>The best program</p></div>
        <ul class="nav">
            <li><a class="active">Log IN</a></li>
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
            <form name="client"  method="post">
                <table align="center">
                    <tr>
                        <td>Login</td>
                        <td><input name="login" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input name="password" type="password"/></td>
                    </tr>
                </table>
                <div class="row">
                    <button type="submit">LOGIN</button>
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
