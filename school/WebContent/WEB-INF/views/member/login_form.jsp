<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
	<style type="text/css">
		#login{
			margin-top: 5em;
		}
	</style>

	<div id="login">
		<div class="loginTop text-center" >
			<img id = "loginform_image" src="${context}/resources/img/member/loginform_image.jpg" />
		</div>
		<form class="form-horizontal">
		<div class="loginCenter row" style="margin-left: 38%;">
				<fieldset class="loginField">
				
					<div class="form-group">
					 	<label for="input_id" class="control-label sr-only">아이디</label>
					 	<div class="col-sm-5">
							<input type="text" class="form-control" id="input_id" name="id" placeholder="아이디를 입력하세요"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="input_pw" class="control-label sr-only">비밀번호</label>
					 	<div class="col-sm-5">
							<input type="password" class="form-control" id="input_pw" name="password" placeholder="비밀번호를 입력하세요"/>
						</div>
					</div>
				</fieldset>
			
		</div>
		<div class="input_button text-center" style="margin-left: 1%;">
		<img id= "loginButton" src="${context}/resources/img/main/button.png" alt="" />
		</div>
		</form>
	</div>
</body>

<script type="text/javascript">
/* 	 $(document).ready(function() {
		
	}); */ 	
	
	$(function() {
		$('#loginform_image').css('border','0').css('width','160px').css('height','160px');
		$('#loginButton').css('width','400px');
	$('#loginButton').click(function() {
	$('form').attr('action','${context}/member/login.do').attr('method','post').submit();
		
	});
	}); 
	// 메인 메소드

		
</script>
</html>