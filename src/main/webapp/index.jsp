<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h1>NBA Stats Fun</h1>

<a href = "logIn">Log in</a>
<%--<h3>Welcome ${userName}</h3>--%>
<p>This page is currently under construction.</p>
<c:if test="${not empty currentUser}" >
    <p>You are logged in.</p>
</c:if>
<br>
<form action="showUsers">
    <button type="submit" name="submit" value="viewAll">View Current Users</button>
</form>

</body>
</html>
