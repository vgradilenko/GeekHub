<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<h1>Create User page</h1>
<form action="/createUser" method="post">
    <table border="0">
        <tr>
            <td>First Name</td>
        </tr>
        <tr>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>Last Name</td>
        </tr>
        <tr>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td>Age</td>
        </tr>
        <tr>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form>
</body>
</html>
