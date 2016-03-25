<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var ="context" value = "<%=request.getContextPath()%>"/>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>
	<img id="image" />
</body>
<script type="text/javascript">

$(document).ready(function() {
	$('img').attr('src','${context}/resources/img/main/loading-icon.gif').css('margin-left','35%').css('margin-top','10%');
		location.href='${context}/global/main.do';
});
</script>
</html>  