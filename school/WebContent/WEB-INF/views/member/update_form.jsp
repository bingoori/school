<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div>
<div id="join">
		<div class="updateTop">
			<h2 class="text-center">회원 정보 수정</h2>
		</div>
		<div class="updateCenter row">
			<form >
				<fieldset class="updateField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.id}" readonly/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="password" name="password" value="${sessionScope.user.password}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" value="${sessionScope.user.name}" readonly/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr" value="${sessionScope.user.addr}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" value="${sessionScope.user.birth}" readonly/>
						</div>
					</div>
					<div class="input_button text-center">
					<button id="updateButton">수정</button>
					</div>				
				</fieldset>
			</form>
		</div>
	</div>
		<jsp:include page="../global/footer.jsp" />
		<script type="text/javascript">
	
		$(function() {
			$('form').addClass('form-horizontal');	
			$('#updateButton').addClass('btn btn-primary');
			$('#updateButton').click(function() {
				$('form').attr('action','${context}/member/update.do').attr('method','post').submit();		
			});
		
		});
		</script>
</div>