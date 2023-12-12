<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="navbar.jsp" %>

<c:if test="${empty currentUser}" >
    <div class="bg-dark text-secondary px-4 py-5 text-center">
        <div class="py-5">
            <h1 class="display-5 fw-bold text-white">Welcome</h1>
            <div class="col-lg-6 mx-auto">
                <p class="fs-5 mb-4"><a href = "logIn">Log in</a> to track your favorites teams.</p></p>
                    <%--            <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">--%>
                    <%--                <button type="button" class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold">Custom button</button>--%>
                    <%--                <button type="button" class="btn btn-outline-light btn-lg px-4">Secondary</button>--%>
                    <%--            </div>--%>
            </div>
        </div>
    </div>
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
<%--<p><a href="${pageContext.request.contextPath}/teams">View All Teams</a></p>--%>
<%--<form action="showUsers">--%>
<%--    <button type="submit" name="submit" value="viewAll">View Current Users</button>--%>
<%--</form>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
