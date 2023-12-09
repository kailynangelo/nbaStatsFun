<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>NBA Teams</h1>
<table class="table">
    <thead>
    <th>Team</th>
    <th>Location</th>
    </thead>
    <tbody>
    <c:forEach var="team" items="${teams}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/viewTeam?teamName=${team.teamName}">${team.fullName}</a></td>
            <td>${team.city}, ${team.state}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="index.jsp">Return to Home</a></p>
</body>
</html>
