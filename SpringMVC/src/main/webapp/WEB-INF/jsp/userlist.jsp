<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>This is SpringMVC demo pages</title>
</head>
<body>
    <c:forEach items="${users}" var="user">
        <c:out value="${user.username}"></c:out>
        <br>
        <c:out value="${user.age}"></c:out>
        <br>
    </c:forEach>
</body>
</html>
