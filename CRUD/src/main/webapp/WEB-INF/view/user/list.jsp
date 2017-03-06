<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/webjars/bootstrap/3.3.7/css/bootstrap.css" />" rel="stylesheet">
    <title>List of users</title>
</head>
<body>
<h1>List of users</h1>
<form action="/createUser" method="get">
    <input type="submit" value="create">
</form>
<table border="0">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${page.items}" var="user">
    <tr>
    <td><c:out value="${user.firstName}"/></td>
    <td><c:out value="${user.lastName}"/></td>
    <td><c:out value="${user.age}"/></td>
    <td><a href="/showUser?id=<c:out value="${user.id}"/>">show</a></td>
    <td><a href="/updateUser?id=<c:out value="${user.id}"/>">edit</a></td>
    <td><a href="/deleteUser?id=<c:out value="${user.id}"/>">delete</a></td>
    </tr>
    </c:forEach>
</table>
<c:forEach begin="1" end="${page.pageCount}" var="i">
    <a href="<c:url value="/users?page=${i}"/>">${i}</a>
</c:forEach>
</body>
</html>
