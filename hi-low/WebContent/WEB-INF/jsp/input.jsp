<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hi-Low Game</title>
</head>
<body>
	<h1>ハイ・ロー ゲーム</h1>
	<p>1～99までのどれかの数字を入れてね</p>
	<form action="/hi-low/play" method="post">
		<input type="text" name="number">
		<input type="submit" value="OK">
	</form>
</body>
</html>