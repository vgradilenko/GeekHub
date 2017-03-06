<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List of reviews</h1>

<table border="0">
    <tr>
        <th>First Name</th>
        <th>Rating</th>
        <th>Review</th>
        <th>Date</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach items="${page.items}" var="review">
        <tr>
            <td><c:out value="${review.name}"/></td>
            <td><c:out value="${review.rating}"/></td>
            <td><c:out value="${review.review}"/></td>
            <td><c:out value="${review.date}"/></td>

        </tr>
    </c:forEach>
</table>
<c:forEach begin="1" end="${page.pageCount}" var="i">
    <a href="<c:url value="/reviews?page=${i}"/>">${i}</a>
</c:forEach>
</body>
</html>
