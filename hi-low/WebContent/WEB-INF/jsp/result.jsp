<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hi-Low Game</title>
</head>
<body>
	<h1>ハイ・ロー ゲーム結果</h1>
	<p><%= msg %></p>
	<p><a href="/hi-low/play">もどる</a></p>
</body>
</html>