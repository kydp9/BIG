

<%@include file="includes.jsp"%>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Weather  v 1.05</title>
    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Weather  v 0.001 </h1>
<form:form action="weather.do" method="POST" commandName="weather">
    <table>
        <tr>
            <td>Search data</td>
            <td><form:input path="city" /></td>

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
    <th>city</th>
    <th>date</th>
    <th>Температура Днем</th>
    <th>Температура вечером</th>
    <th>Завтра</th>
    <th>Завстра вечер</th>
    <th>День 3</th>
    <th>wDay3Evng</th>
    <c:forEach items="${weatherList}" var="weather">
        <tr>
            <td>${weather.city}</td>

            <td >  <calendar:formatDate  value="${weather.date}"
                                         pattern="EEE-dd-MM"/>   </td>
            <td>${weather.wDay1Day}</td>
            <td>${weather.wDay1Evng}</td>
            <td>${weather.wDay2Day} </td>
            <td>${weather.wDay2Evng}</td>
            <td>${weather.wDay3Day}</td>
            <td>${weather.wDay3Evng}</td>
        </tr>




    </c:forEach>
</table>
</body>
</html>
