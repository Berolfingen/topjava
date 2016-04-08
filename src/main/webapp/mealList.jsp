<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Meals</title>
</head>
<style>
    .green {
        background-color: green
    }

    .red {
        background-color: red
    }

    input {
        border: ridge black;
    }
</style>
<body>
<h2>Meals</h2>
<table border="1">
    <tr>
        <th>DateTime</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <form method="post" action="meals">
        <c:forEach items="${meals}" var="meals">
            <c:set var="rowStyle" value="${meals.exceed== true?'red':'green'}"/>
            <tr class="${rowStyle}">
                <td style="display: none">${meals.id}</td>
                <td>${meals.dateTime}</td>
                <td>${meals.description}</td>
                <td>${meals.calories}</td>
                <td>
                    <button type="submit" name="update" value="${meals.id}">Update</button>
                </td>
                <td>
                    <button type="submit" name="delete" value="${meals.id}">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </form>
</table>

<br>

<form action="meals" method="post">
<div>
    Datetime <input type="datetime-local" name="datetime" value="${meal.dateTime}">
    Description <select name="description" value="<c:out value="${meal.description}"/>">
    <option value="Завтрак">Завтрак</option>
    <option value="Обед">Обед</option>
    <option value="Ужин">Ужин</option>
</select>
    Calories <input type="text" name="calories" value="<c:out value="${meal.description}"/>"
    <button type="submit" name="addUpdate">Add/Update</button>
</div>
</form>

</body>
</html>
