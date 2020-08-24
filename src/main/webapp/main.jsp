<jsp:useBean id="shapes" scope="request" type="java.util.List"/>
<%@ page import="java.io.File" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="by.shibaev.shape.entity.Shape" %>
<%@ page import="by.shibaev.shape.entity.shape.Sphere" %>
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
    <select name="file">
        <%
            if (files != null) {
                for (File file : files) {
                    out.println("<option>" + file.getName() + "</option>");
                }
            }
        %>
    </select>
    <input type="submit" value="Get list" id="get">
    <table>
        <%
            for (Object shape : shapes) {
                if (shape instanceof Sphere) {
                    Sphere sphere = (Sphere) shape;
                    out.println(
                            "<tr>" +
                                    "<td>" + sphere.getId() + "<td>"
                                    +
                                    "<td>" + sphere.getRadius() + "<td>"
                                    +
                                    "<td>" + sphere.getCenter().getxPosition() + "<td>"
                                    +
                                    "<td>" + sphere.getCenter().getyPosition() + "<td>"
                                    +
                                    "<td>" + sphere.getCenter().getzPosition() + "<td>"
                                    + "</tr>"
                    );
                }
            }
        %>
    </table>
</form>
</body>
</html>
