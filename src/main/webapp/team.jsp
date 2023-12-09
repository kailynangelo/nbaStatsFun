<%--
  Created by IntelliJ IDEA.
  User: kaily
  Date: 12/9/2023
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <p><a href="${pageContext.request.contextPath}/teams">View All Teams</a></p>
    <p><a href="index.jsp">Return to Home</a></p>
</body>
</html>
