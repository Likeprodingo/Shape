<%@ page import="java.io.File" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="by.shibaev.shape.entity.Shape" %>
<%@ page import="by.shibaev.shape.entity.shape.Sphere" %>
<%@ page import="java.util.List" %>
<%@ page import="by.shibaev.shape.repository.ShapeRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    File folder = new File("D:\\servlet\\src\\main\\resources\\upload");
    File[] files = folder.listFiles();
%>
<html>
<head>
    <title>MAIN PAGE</title>
</head>
<body>
<form action="controller" method="GET">
    <select name ="file">
        <%
            if (files != null) {
                for (File file : files) {
                    out.println("<option>" + file.getName() + "</option>");
                }
            }
        %>
    </select>
    <input type="submit" value="Get list">
    <ul>
        <%
            List<Shape> shapes = ShapeRepository.getInstance().getShapes();
            if (files != null) {
                for (Shape shape : shapes) {
                    Sphere sphere = (Sphere) shape;
                    out.println("<li>" + sphere + "</li>");
                }
            }
        %>
    </ul>
</form>
</body>
</html>
