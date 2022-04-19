<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Uranai" %>
<%
Uranai uranai = new Uranai();
String word = uranai.getFortune();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占い</title>
</head>
<body>
	<h1>今日の運勢</h1>
	<p>あなたの今日の運勢は <%= word %> です。</p>
</body>
</html>