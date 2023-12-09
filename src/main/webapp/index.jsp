<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h1>NBA Stats Fun</h1>
<br>
<h3>Welcome</h3>
<p><a href = "logIn">Log in</a></p>
<c:if test="${empty currentUser}" >
    <p>Log in to view and edit your saved teams.</p>
</c:if>
<c:if test="${not empty currentUser}" >
    <p>You are logged in as ${currentUser.userName}</p>
    <table>
        <tr>
            <th>Full Name</th>
            <td>${currentUser.firstName} ${currentUser.lastName}</td>
        </tr>
        <tr>
            <th>Favorite Teams</th>
            <td>
                <c:forEach var="team" items="${currentUser.favoriteTeams}">
                    <a href="${pageContext.request.contextPath}/viewTeam?teamName=${team.teamName}">${team.fullName}</a><br>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/updateFavorites">Edit favorite teams</a>
            </td>
        </tr>
    </table>
</c:if>
<br>
<p><a href="${pageContext.request.contextPath}/teams">Go to Teams Page</a></p>
<form action="showUsers">
    <button type="submit" name="submit" value="viewAll">View Current Users</button>
</form>

</body>
</html>
