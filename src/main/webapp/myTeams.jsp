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
    <p>
    <ul>
      <c:forEach var="team" items="${currentUser.favoriteTeams}">
        <li>${team.fullName}</li>
      </c:forEach>
    </ul>
    <a>add team</a>
    </p>

    <p><a href="index.jsp">Return to Home</a></p>
</body>
</html>
