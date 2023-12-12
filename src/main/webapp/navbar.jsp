<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="${pageContext.request.contextPath}/" class="nav-link text-dark">NBAStatsFun</a></li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/" class="nav-link">Home</a></li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/teams" class="nav-link">Teams</a></li>
<%--            <li class="nav-item"><a href="${pageContext.request.contextPath}/showUsers" class="nav-link">Users</a></li>--%>
<c:if test="${empty currentUser}">
            <li class="nav-item"><a href="${pageContext.request.contextPath}/logIn" class="nav-link active" aria-current="page">Log In</a></li>
</c:if>
<c:if test="${not empty currentUser}">
            <li class="nav-item"><a href="${pageContext.request.contextPath}/" class="nav-link active" aria-current="page">Hi, ${currentUser.userName}</a></li>
</c:if>
        </ul>
    </header>
</div>