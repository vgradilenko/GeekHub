<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<h1>Create User page</h1>
<form action="/updateUser" method="get">
    <input type="hidden" name="id" value="${user.id}">
    <table border="0">
        <tr>
            <td>First Name</td>
        </tr>
        <tr>
            <td><input type="text" name="firstName" value="${user.firstName}"></td>
        </tr>
        <tr>
            <td>Last Name</td>
        </tr>
        <tr>
            <td><input type="text" name="lastName" value="${user.lastName}"></td>
        </tr>
        <tr>
            <td>Age</td>
        </tr>
        <tr>
            <td><input type="text" name="age" value="${user.age}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form>
</body>
</html>
