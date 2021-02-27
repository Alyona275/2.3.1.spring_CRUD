<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.id}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty user.id}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.id}">
    <c:url value="/add" var="var"></c:url>
</c:if>
<c:if test="${!empty user.id}">
    <c:url value="/update" var="var"></c:url>
</c:if>

<form action="${var}" method="POST">
    <c:if test="${!empty user.id}">
        <input type="hidden" name="id" id="id" value="${user.id}">
    </c:if>
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="age">Age</label>
    <input type="text" name="age" id="age">
    <label for="email">Email</label>
    <input type="text" name="email" id="email">
    <c:if test="${empty user.id}">
        <input type="submit" value="Add user">
    </c:if>
    <c:if test="${!empty user.id}">
        <input type="submit" value="Update user">
    </c:if>
</form>
</body>
</html>
