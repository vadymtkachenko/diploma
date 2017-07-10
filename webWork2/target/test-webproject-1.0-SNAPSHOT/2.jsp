<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<html>
<%--<script type="text/javascript">--%>
    <%--function EmpList() {--%>
        <%--window.location.href = '/allEmployeesList';--%>
    <%--}--%>
<%--</script>--%>
<head>
    <title>ГОСТИ</title>
</head>
<body>
<H1>ГОСТИ</H1>
<br>
<br>
<table border="1px">
    <tr>
        <td width="30">#</td>
        <td width="20">ID</td>
        <td width="200">Имя</td>
        <td width="40">Фамилия</td>
        <td width="60">С кем</td>
        <td width="60">Телефон</td>
        <td width="60">Действие 1</td>
        <td width="60">Действие 2</td>
    </tr>
    <c:forEach items="${clients}" var="client" varStatus="status" >
        <tr>
            <td>${status.index + 1}</td>
            <td>${client.id}</td>
            <td>${client.name}</td>
            <td>${client.surname}</td>
            <td>${client.with}</td>
            <td>${client.telephone}</td>
            <td><a href="/clientEdit?id=${client.id}">Изменить</a></td>
            <td><a href="/clientDelete?id=${client.id}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<%--<input type="button" onclick="EmpList()" value="Employees List"/>--%>
<br/>
<a href="/AddClient">
    <input type="button" value="Добавить гостя" />
</a>
</body>
</html>
