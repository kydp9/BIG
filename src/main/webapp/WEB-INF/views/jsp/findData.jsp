
<%@include file="includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Human Manager v 1.06</title>
    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<h1>seearch v 0.004 </h1>
<form:form action="search.do" method="POST" commandName="human">
    <table>
        <tr>
            <td>Search data</td>
            <td><form:input path="surname" /></td>

        </tr>

        <tr>
            <td colspan="2">

                <input type="submit" name="action" value="Search" />

            </td>
        </tr>
    </table>
</form:form>
<br>
<table border="1">
    <th>ID</th>
    <th>Name</th>
    <th>Last name</th>
    <th>Surname</th>
    <th>Car</th>
    <th>City</th>
    <c:forEach items="${humanList}" var="human">
        <tr>
            <td>${human.id}</td>
            <td>${human.name}</td>
            <td>${human.secondName}</td>
            <td>${human.surname}</td>
            <td>${human.car}</td>
            <td>${human.city}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
