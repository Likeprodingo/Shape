<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MAIN PAGE</title>
</head>
<body>
<form action="controller" method="post">
    <select name ="file">
        <c:forEach var="file" items="${files}">
            <option>${file}</option>
        </c:forEach>
    </select>
    <input type="hidden" name = "command" value="get_sphere">
    <input type="submit" value="Get">
    <table>
        <c:forEach var="sphere" items="${spheres}">
            <tr>
                <td>Sphere</td>
                <td>${sphere.getRadius()}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
