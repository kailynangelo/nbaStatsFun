<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <h1>Current Users @ NBA Stats Fun</h1>
    <table class="table">
        <thead>
            <th>Name</th>
            <th>Username</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="index.jsp">Return to Home</a></p>
</body>
</html>
