<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Sogongdo/facilityCharge/update" method="POST">
		<input type="text" name="touristSite"><br>
		<input type="text" name="facility"><br>
		<input type="text" name="charge"><br>
		<input type="submit" value="수정">
		<input type="button" onclick="history.back()" value="취소">
	</form>
</body>
</html>