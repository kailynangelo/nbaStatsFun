<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@include file="navbar.jsp" %>
    <h1>Current Users @ NBA Stats Fun</h1>
    <table class="table">
        <thead>
            <th>Name</th>
            <th>Username</th>
            <th>Favorite Teams</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
<%--                <td>${user.favoriteTeams}</td>--%>
                <td><ul>
                    <c:forEach var="team" items="${user.favoriteTeams}">
                        <li>${team.fullName}</li>
                    </c:forEach>
                </ul></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="index.jsp">Return to Home</a></p>
</body>
</html>
