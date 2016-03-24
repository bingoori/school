<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div id="join">
	<div class="joinTop">
		<h2 class="text-center">회원 상세 정보</h2>
	</div>
	<div class="joinCenter row">
		<form action="${context}/member/update_form.do" name="updateForm"
			class="form-horizontal">
			<fieldset class="joinField">
				<div class="form-group">
					<label for="input_id" class="col-sm-4 control-label">아이디</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="id" name="id"
							value=" ${member.id}" readonly />

					</div>
				</div>
				<div class="form-group">
					<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="password"
							name="password" value="${member.password}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">이름</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="name" name="name"
							value="${member.name}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">주소</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="addr" name="addr"
							value=" ${member.addr}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="birth" name="birth"
							value="${member.birth}" readonly />
					</div>
				</div>
	</div>
	</fieldset>
	</form>
	
	<div class="input_button text-center">
		<form action="${context}/grade/my_grade.do">
		
		<input type="submit" id="updateButton" class="btn btn-primary" value="성적" /> 
		<input type="hidden" id="id" name="id" value="${member.id}" />
		
		<input type="submit" formaction="${context}/member/update_form.do" id="updateButton" class="btn btn-primary" value="수정" /> 
		<input type="hidden" id="update" name="update" value="${member.id}" />
		
		<input type="submit" formmethod="post" formaction="${context}/member/delete.do" id="deleteButton" class="btn btn-primary" value="삭제" /> 
		<input type="hidden" id="delete" name="delete" value="${member.id}" />
		<input type="submit" value="홈으로" formaction="${context}/global/main.do" class="btn btn-primary"/>
		</form>
			
	</div>
		<jsp:include page="../global/footer.jsp" />
</div>