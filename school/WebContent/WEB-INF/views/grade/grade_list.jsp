<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<jsp:include page="../global/header.jsp" />

	<c:forEach var="score" items="${requestScope['totalScore']}">
		<c:out value="${score.id}" />
		<c:out value="${score.password}" />
		<c:out value="${score.name}" />
		<c:out value="${score.addr}" />
		<c:out value="${score.birth}" />
		<c:out value="${score.java}" />
		<c:out value="${score.jsp}" />
		<c:out value="${score.sql}" />
		<c:out value="${score.spring}" />
		<br>
	</c:forEach>
	<jsp:include page="../global/footer.jsp" />
</div>