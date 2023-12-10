<%--
  Created by IntelliJ IDEA.
  User: kaily
  Date: 12/9/2023
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Team Home</title>
</head>
<body>
    <h1>${team.fullName}</h1>
    <table>
        <tr><th>Team Name</th><td>${team.teamName}</td></tr>
        <tr><th>Location</th><td>${team.city}, ${team.state}</td></tr>
        <tr><th>Conference</th><td>${team.conference}</td></tr>
        <tr><th>Division</th><td>${team.division}</td></tr>
    </table>
    <hr>
    <h3>Team Roster</h3>
    <table>
        <thead>
            <th>Name</th>
            <th>Birthdate</th>
            <th>Position</th>
            <th>Jersey #</th>
            <th>Home Country</th>
        </thead>
        <tbody>
        <c:forEach var="player" items="${players}">
            <tr>
            <td>${player.firstName} ${player.lastName}</td>
            <td>${player.birthdate}</td>
            <td>${player.position}</td>
            <td>${player.jerseyNumber}</td>
            <td>${player.homeCountry}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="${pageContext.request.contextPath}/teams">View All Teams</a></p>
    <p><a href="index.jsp">Return to Home</a></p>
</body>
</html>
