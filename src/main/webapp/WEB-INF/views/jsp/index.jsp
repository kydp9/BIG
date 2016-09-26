<%--
  Created by IntelliJ IDEA.
  User: ikydp
  Date: 25.09.2016
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: ikydp
  Date: 02.09.2016
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes.jsp"%>

<html>
<head>
    <title>Альфа тест</title>
</head>
<body>
<h1>доступ ко всем страницам</h1>
<form:form action="index.do" method="POST" commandName="index">
    <table>


            <td colspan="2">
                <input type="submit" name="action" value="humanfind" />
                <input type="submit" name="action" value="usersend" />
                <input type="submit" name="action" value="weather" />
                <input type="submit" name="action" value="weatherJSON" />
            </td>

    </table>
</form:form>
<br>

</body>
</html>
