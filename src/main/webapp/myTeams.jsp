<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="navbar.jsp" %>
<div class="container px4 py5">
<h1 class="text-center">Manage your favorite teams</h1>
<br>
<%--<ul class="list-group list-group-flush">--%>
  <c:forEach var="team" items="${currentUser.favoriteTeams}">
<%--    <li class="list-group-item">--%>
<%--        <form id="removeTeam" action="updateFavorites" method="post">--%>
<%--            <input type="hidden" name="teamToRemove" value="${team.teamName}" id="teamToRemove"/>--%>
<%--            <button type="submit" name="actionType" value="remove"--%>
<%--                    class="btn btn-primary">remove team</button>--%>
<%--        </form>--%>
    <div class="row mb-2">
        <div class="col-sm-4">${team.fullName}</div>
        <div class="col-sm-8">
            <form id="removeTeam" action="updateFavorites" method="post">
                <input type="hidden" name="teamToRemove" value="${team.teamName}" id="teamToRemove"/>
                <button type="submit" name="actionType" value="remove"
                        class="btn btn-sm btn-primary">remove team</button>
            </form>
        </div>
    </div>
<%--    </li>--%>
  </c:forEach>
<%--</ul>--%>
<br>
<form id="addTeam" action="updateFavorites" method="post">
    <label for="teamToAdd" class="form-label">Add a team</label>
    <select name="teamToAdd" id="teamToAdd">
        <c:forEach var="team" items="${teams}">
            <option value="${team.teamName}">${team.fullName}</option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-sm btn-primary" name="actionType" value="add">add team</button>
</form>
</div>
</body>
</html>
