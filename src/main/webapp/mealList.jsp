<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h2>Meals</h2>
<table>
    <tbody>DateTime</tbody>
    <tbody>Description</tbody>
    <tbody>Calories</tbody>
    <c:forEach items="${meals}" var="meals">
        <tr>
            <td><c:out value="${meals.dateTime}"/><td>
            <td><c:out value="${meals.description}"/><td>
            <td><c:out value="${meals.calories}"/><td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
