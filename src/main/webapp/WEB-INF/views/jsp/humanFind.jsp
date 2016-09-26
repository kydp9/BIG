<%--
  Created by IntelliJ IDEA.
  User: ikydp
  Date: 02.09.2016
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>


<%@include file="includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Human Manager v 1.05</title>
    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<h1>humanslist Data v 1.05</h1>
<form:form action="find.do" method="POST" commandName="human">
    <table>
        <tr>
            <td>Human ID</td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><form:input path="name" /></td>
            <td><span class="error"><form:errors path="name" /></span></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><form:input path="secondName" /></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><form:input path="surname" /></td>
            <td><span class="error"><form:errors path="surname" /></span></td>
        </tr>
        <tr>
            <td>Car</td>
            <td><form:input path="car" /></td>
            <td><span class="error"><form:errors path="car" /></span></td>
        </tr>
        <tr>
            <td>City</td>
            <td><form:input path="city" /></td>
            <td><span class="error"><form:errors path="city" /></span></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add" />
                <input type="submit" name="action" value="Edit" />
                <input type="submit" name="action" value="Delete" />
                <input type="submit" name="action" value="Search" />
                <input type="submit" name="action" value="GetId" />
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
