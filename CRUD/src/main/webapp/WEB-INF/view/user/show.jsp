<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show user</title>
</head>
<body>
<table>
    <tr>
        <td>First Name :</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td>Last Name :</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td>Age :</td>
        <td>${user.age}</td>
    </tr>
</table>
<table>
    <tr>
    <td> <form method="post" action="/updateUser">
        <input type="hidden" name="id" value="${user.id}">
        <input type="submit" value="Edit">
    </form> </td>
    <td> <form method="get" action="/deleteUser">
        <input type="hidden" name="id" value="${user.id}">
        <input type="submit" value="Delete">
    </form> </td>
    </tr>
</table>

</body>
</html>
