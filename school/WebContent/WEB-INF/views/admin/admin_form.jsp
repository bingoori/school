<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp" />

<div class="container" style="width: 1000px; margin: 0 auto;">
	<div class="row display-table">
		<div class="col-xs-12 col-sm-4 display-cell">
			<ul id='admin_sidebar' class="nav nav-pills nav-stacked">
				<li id ='allList'><a onclick="admin.memberList()">전체학생 목록보기</a></li>
				<li id ='gradeList'><a onclick="admin.gradeList()">전체성적 목록보기</a></li>
				<li id = 'searchById'><a onclick="admin.searchById()">ID로 회원검색</a></li>
				<li id = 'gradeAdd'><a onclick="admin.addScore()">학생 점수 입력</a></li>
			</ul>
		</div>
		<div class="col-xs-12 col-sm-8 display-cell" id="result"
			style="border: 1px solid black; height: 500px">
			<div id='memList' style="display: none;">
				 <jsp:include page="member_list.jsp" /> 
			</div>
			<div id='memAdd' style="display: none;">
				<jsp:include page="member_add.jsp" />
			</div>
		</div>
		<%-- 		 <jsp:include page="member_list.jsp" /> --%>
	</div>

	<fieldset>
		<legend>회원관리</legend>
		<table class="table-condensed" style="width: 90%; margin-left: 50px">
			<tr>
				<td>전체회원 목록보기</td>
				<td>
					<div id='totalList' style="display: none;">
						<%-- 	<jsp:include page="member_list.jsp" /> --%>
					</div>
				</td>
			</tr>
			<tr>
				<td>ID 로 회원검색</td>
				<td>
					<div id='showById' style="display: none;">
						<!-- <input type="text" id="showById" name="searchById" /> -->
					</div>
				</td>
			</tr>
			<tr>
				<td>이름으로 회원검색(동명이인 허용)</td>
				<td>
					<div id='showByName' style="display: none;">
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
					<button onclick="view.showList()">전체 회원 목록</button> <br />
					<button onclick="view.showAdd()">학생 점수 입력</button> <br />
					<button onclick="view.showById()">아이디로 회원 검색</button> <br />
					<button onclick="view.showByName()">이름으로 회원 검색</button> <br />
					<button onclick="view.hide()">닫기</button>
				</td>
			</tr>
		</table>
	</fieldset>

	<!-- "/grade/admin_list2.do" -->
	<script src="$(context)/resources/js/admin.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
	 

		 	//$('#admin_sidebar').children().first().addClass('dropdown active');
			$('#allList').click(function() {
				$(this).siblings().removeClass('dropdown active');
				$(this).addClass('dropdown active');
				document.getElementById('memAdd').style.display = 'none';
				document.getElementById('memList').style.display = '';				 

			});
			$('#gradeAdd').click(function() {
				$(this).siblings().removeClass('dropdown active');
				$(this).addClass('dropdown active');
				document.getElementById('memList').style.display = 'none';				 
				document.getElementById('memAdd').style.display = '';				 
			});
		});
		var view = {

			//document.getElementById("result").innerHTML = "1to100Sum : " + sum;
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
				document.getElementById('showById').action = '${context}/admin/searchById.do';
				document.getElementById('showById').method = methodType;
				document.getElementById("showById").submit();

			},
			showByName : function() {
				document.getElementById('showByName').style.display = 'none';
			},
			showList : function() {
				document.getElementById('totalList').style.display = 'none';

			}

		}
	</script>