<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<br>
<div>
<div class="mg_auto" style="width: 1000px;">

	<table border="1">
		<tr>
			<td>과목</td>
			<td>점수</td>
	
		</tr>
		<tr>
			<td>JAVA</td>
			<td>null</td>

		</tr>
		<tr>
			<td>JSP</td>
			<td>null</td>
	
		</tr>
		<tr>
			<td>SQL</td>
			<td>null</td>
	
		</tr>
		<tr>
			<td>SPRING</td>
			<td>null</td>
	
		</tr>
	</table>
	</div>
	<p>
	<br>
	<div class= "mg_auto" style="width: 1000px;"><form action="${context}/global/main.do">
	<input type="submit" value="홈으로"/></form> </div>
	<jsp:include page="../global/footer.jsp" />
</div>