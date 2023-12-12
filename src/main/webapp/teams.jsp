<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
<h1 class="text-center">NBA Teams</h1>
<div class="table-responsive px-4">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th scope="col">Team</th>
            <th scope="col">Location</th>
        </tr>
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
</div>
</div>
</body>
</html>
