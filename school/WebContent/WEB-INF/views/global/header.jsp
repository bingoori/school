<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="time" value="<%= new java.util.Date()%>" />
<c:set var="user" value="${sessionScope.user }" />
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>성적관리</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
</head>

<body> 	

<c:out value="${user}"/>

<c:choose>
	<c:when test="${empty sessionScope.user} ||  ${empty sessionScope.admin}">
		<jsp:include page="../global/default_header.jsp"/>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${user.role eq 'admin'}">
				<jsp:include page="../admin/admin_header.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="../member/member_header.jsp"/>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>

