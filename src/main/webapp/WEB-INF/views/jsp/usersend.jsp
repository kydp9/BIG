
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes.jsp"%>


<html>
<head>
    <title>TExt sender </title>
</head>
<body>
<h1>Sender v 0.001 русс текст</h1>
<form:form action="usersend.do" method="POST" commandName="user">
    <table>
        <div class="form">
        <tr>
            <td>Name</td>
            <td><form:input path="name" /></td>
            <td><span class="error"><form:errors path="name" /></span></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><form:input path="second" /></td>
            <td><span class="error"><form:errors path="second" /></span></td>

        </tr>
        <tr>
            <td>Surname</td>
            <td><form:input path="surname" /></td>
            <td><span class="error"><form:errors path="surname" /></span></td>
        </tr>
            <tr>
                <td>Email</td>
                <td><form:input path="email" /></td>
                <td><span class="error"><form:errors path="email" /></span></td>
            </tr>
        <tr>
            <td>SentTo</td>
<td>
           <select name = "sendto">
                <option value = "Иван Иванович Иванов">Иванов</option>
                <option value = "Владимер Владиморович Букин">Букин</option>
                <option value="Алег Олегович Алегатор">Крокодил</option>
            </select>

</td>


        </tr>
        <tr>
            <td>Subject</td>
            <td><form:input path="subject" /></td>

        </tr>
            </div>
        <tr>
            <td>Text</td>

            <td><form:input path="text"  /></td>
        </tr>
        <tr>
            <td >
                <input type="submit" name="action" value="send" />
                <input type="submit" name="action" value="search" />
            </td>
        </tr>

    </table>

</form:form>
<br>
<table border="1">

    <th>Name</th>
    <th>Last name</th>
    <th>Surname</th>
    <th>email</th>
    <th>сообщение для</th>
    <th>тема</th>
    <td>Сообщение</td>
    <c:forEach items="${userList}" var="user">
        <tr>

            <td>${user.name}</td>
            <td>${user.second}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.sendto}</td>
            <td>${user.subject}</td>
            <td>${user.text}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
