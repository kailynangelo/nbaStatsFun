<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="navbar.jsp" %>

<c:if test="${empty currentUser}" >
    <div class="bg-dark text-secondary px-4 py-5 text-center">
        <div class="py-5">
            <h1 class="display-5 fw-bold text-white">NBA Stats Fun</h1>
            <div class="col-lg-6 mx-auto">
                <p class="fs-5 mb-4"><a href = "logIn">Log in</a> to track your favorites teams.</p>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${not empty currentUser}" >
    <div class="px-4 py-5 my-5 text-center">
        <h1 class="display-5 fw-bold">NBA Stats Fun</h1>
        <div class="col-lg-6 mx-auto">
            <h2 class="">Welcome back, ${currentUser.userName}</h2>
            <br>
            <p>Name: ${currentUser.firstName} ${currentUser.lastName}</p>
            <h3>Favorite Teams</h3>
            <ul class="list-group">
            <c:forEach var="team" items="${currentUser.favoriteTeams}">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/viewTeam?teamName=${team.teamName}">${team.fullName}</a></li>
            </c:forEach>
            </ul>
            <br>
            <a href="${pageContext.request.contextPath}/updateFavorites">Edit favorite teams</a>
        </div>
    </div>
</c:if>
<br>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>--%>
</body>
</html>
