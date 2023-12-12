<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@include file="navbar.jsp" %>
<hr>
<div class="container">
    <h1 class="text-center">${team.fullName}</h1>
    <div class="table-responsive px-4">
    <table class="table table-sm">
        <tr><th>Team Name</th><td>${team.teamName}</td></tr>
        <tr><th>Location</th><td>${team.city}, ${team.state}</td></tr>
        <tr><th>Conference</th><td>${team.conference}</td></tr>
        <tr><th>Division</th><td>${team.division}</td></tr>
    </table>
    </div>
    <h3>Team Roster</h3>
    <div class="table-responsive px-4">
    <table class="table table-striped table-sm">
        <thead>
            <th scope="col">Name</th>
            <th scope="col">Birthdate</th>
            <th scope="col">Position</th>
            <th scope="col">Jersey #</th>
            <th scope="col">Home Country</th>
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
    </div>
</div>
</body>
</html>
