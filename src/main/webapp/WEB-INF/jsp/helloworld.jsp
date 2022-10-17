<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
    <head>
        <title>
            Greeting
        </title>
    </head>
    <body>
    <form action="/demo/hello" method="post"enctype="multipart/form-data">
        <p>
            <label for="name">What's your name?</label>
            <input id="name" name="name" value="${fn:escapeXml(param.name)}">
        </p>
    </form>
    </body>
</html>