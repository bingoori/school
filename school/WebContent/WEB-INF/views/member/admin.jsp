<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div id="join">
	<div class="joinTop">
		<h2 class="text-center">관리자 화면</h2>
	</div>
	 <h1>관리자 화면</h1>
<div style="margin-left: 43.5%;">
   <a href="${context}/grade/admin_list.do">회원 정보 리스트</a><br/>
   <a href="${context}/grade/grade_addform.do">회원 정보 추가</a><br/>
   <a href="${context}/global/main.do">홈으로</a>
   	
</div>

		<jsp:include page="../global/footer.jsp" />
</div>