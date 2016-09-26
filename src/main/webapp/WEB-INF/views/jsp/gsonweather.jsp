<%--
  Created by IntelliJ IDEA.
  User: ikydp
  Date: 20.09.2016
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes.jsp"%>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Weather  v 1.06</title>
    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Weather JSON  v 0.001 </h1>


<table border="1">


    <c:forEach items="${weatherList}" var="weather">
        <tr>
            <td>${weather}</td>


        </tr>




    </c:forEach>
</table>
</body>
</html>
