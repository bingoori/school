<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--    <table>
    	<tr>
    		<th>아이디</th>
    		<th>이름</th>
    		<th>전공</th>
    		<th>수강과목</th>
    		<th>주소</th>
    		<th>생년월일</th>

    	</tr>
    	<c:forEach var="member" items="${requestScope['totalScore']}">
    	<tr>
    		<td>${member.id}</td>
    		<td>${member.name}</td>
    		<td>${member.major}</td>
    		<td>${member.subject}</td>
    		<td>${member.addr}</td>
    		<td>${member.birth}</td>
    	</tr>
    	</c:forEach>
    </table>  --%>
 <div>
	<table cellpadding="3" cellspacing="3" border="1" >

		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>생년월일</th>
			<th>Java</th>
			<th>Jsp</th>
			<th>Sql</th>
			<th>Spring</th>
		</tr>
		<c:forEach var="score" items="${requestScope['totalScore']}">
			<tr>
				<td><c:out value="${score.id}" /></td>
				<td><c:out value="${score.password}" /></td>
				<td><c:out value="${score.name}" /></td>
				<td><c:out value="${score.addr}" /></td>
				<td><c:out value="${score.birth}" /></td>
				<td><c:out value="${score.java}" /></td>
				<td><c:out value="${score.jsp}" /></td>
				<td><c:out value="${score.sql}" /></td>
				<td><c:out value="${score.spring}" /></td>
			</tr>
			</c:forEach>
	</table>
	</div>
	

