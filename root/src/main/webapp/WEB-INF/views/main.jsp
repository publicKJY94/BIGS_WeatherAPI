<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button id="postBtn" onclick="submitForm">포스트 요청</button>
	<form id="postForm" action="/weather" method="post">
		<input type="hidden" name="nx" value="55">
		<input type="hidden" name="ny" value="127">
	</form>
	<button id="getBtn" onclick="submitForm">겟 요청</button>
	<form id="getForm" action="/weather" method="get">
		<input type="number" name="nx" value="55" style="display:none;">
		<input type="number" name="ny" value="127" style="display:none;">
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"/>
<script type="text/javascript">
	$postBtn = $('#postBtn');
	$postForm = $('#postForm');
	
	$postBtn.on('click', function(){
		$postForm.submit;
	})
</script>
<script type="text/javascript">
	$getBtn = $('#getBtn');
	$getForm = $('#getForm');
	
	$getBtn.on('click', function(){
		$getForm.submit;
	})
</script>
</html>