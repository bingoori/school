<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp" />

 
<fieldset>
	<legend>회원관리</legend>
	<table class="table-condensed" style="width: 90%; margin-left: 50px">
		<tr>
			<td>전체회원 목록보기</td>
			<td>
				<div id='totalList' style="display: none;">

					<jsp:include page="../grade/grade_list.jsp" />
				</div>
			</td>
		</tr>
		<tr>
			<td>ID 로 회원검색</td>
			<td>
			<div id ='showById'  style="display: none;">
			<input type="text" id="showById" name="searchById" />
			</div>
			</td>
		</tr>
		<tr>
			<td>이름으로 회원검색(동명이인 허용)</td>
			<td>
			<div id ='showByName' style="display: none;">
			<input type="text" id="searchByName" name="searchByName" />
			</div>
			</td>	
		</tr>
		<tr>
			<td>학생 점수 입력</td>
			<td>
				<div id='scoreAdd' style="display: none;">
					<jsp:include page="../grade/grade_add.jsp" />
				</div>
			</td>

		</tr>
		<tr>
			<td colspan="2">
				<button onclick="view.showList()">전체 회원 목록</button><br/>
				<button onclick="view.showAdd()">학생 점수 입력</button><br/>
				<button onclick=>아이디로 회원 검색</button><br/>
				<button onclick="view.showByName()">이름으로 회원 검색</button><br/>
				<button onclick="view.hide()">닫기</button>
			</td>
		</tr>
	</table>
</fieldset> 

<!-- "/grade/admin_list2.do" -->
<script type="text/javascript">
	var view = {
		
		hide : function() {
			document.getElementById('totalList').style.display = 'none'; 
			document.getElementById('scoreAdd').style.display = 'none';
			document.getElementById('showById').style.display = 'none';
			document.getElementById('showByName').style.display = 'none';
			},
		showAdd : function() {
			document.getElementById('scoreAdd').style.display = '';
			},
		showById : function(methodType) {
			document.getElementById('showById').style.display = '';
			document.getElementById('showById').action="${context}/admin/searchById.do";
			document.getElementById('showById').method=methodType;
			document.getElementById("showById").submit();
			
			
			
			
			},
		showByName : function() {
			document.getElementById('showByName').style.display = 'none';
			},
		showList : function() {
				document.getElementById('totalList').style.display = ''; 
			}
		
	}
</script>

<%-- <div style="margin-left: 43.5%;">
   <a href="${context}/grade/admin_list.do">회원 정보 리스트</a><br/>
   <a href="${context}/grade/grade_addform.do">회원 정보 추가</a><br/>
   <a href="${context}/global/main.do">홈으로</a>
   	
</div> --%>