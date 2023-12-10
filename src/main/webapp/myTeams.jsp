<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage your favorites</title>
</head>
<body>
    <h1>Manage your favorite teams</h1>
    <br>
    <h2>${currentUser.userName}'s favorite teams</h2>
    <ul>
      <c:forEach var="team" items="${currentUser.favoriteTeams}">
        <li>
            ${team.fullName}
            <form id="removeTeam" action="updateFavorites" method="post">
                <input type="hidden" name="teamToRemove" value="${team.teamName}" />
                <button type="submit" name="actionType" value="remove">remove team</button>
            </form>
        </li>
      </c:forEach>
    </ul>

    <form id="addTeam" action="updateFavorites" method="post">
        <label for="teamToAdd">Add a team:</label>
        <select name="teamToAdd" id="teamToAdd">
            <c:forEach var="team" items="${teams}">
                <option value="${team.teamName}">${team.fullName}</option>
            </c:forEach>
        </select>
        <button type="submit" name="actionType" value="add">add team</button>
    </form>



    <p><a href="index.jsp">Return to Home</a></p>
</body>
</html>
