<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Meals</title>
</head>
<style>
    .green{background-color: green}
    .red{background-color: red}
</style>
<body>
<h2>Meals</h2>
<table border="1">
    <tr>
    <th>DateTime</th>
    <th>Description</th>
    <th>Calories</th>
    </tr>
    <c:forEach items="${meals}" var="meals">
        <c:set var="rowStyle" value="${meals.exceed== true?'red':'green'}"/>
        <tr class="${rowStyle}">
            <td>${meals.dateTime}</td>
            <td>${meals.description}</td>
            <td>${meals.calories}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
