<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.PlayInfo"%>
<%
PlayInfo p = (PlayInfo) request.getAttribute("pinfo");
String[] hands = { "グー", "チョキ", "パー" };
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん結果</title>
</head>
<body>
	<h1>じゃんけん結果</h1>
	<p>YOU: <%=hands[p.getUser()]%></p>
	<p>COM: <%=hands[p.getCom()]%></p>
	<p>
		WINNER:
		<% if(p.getWinner().equals("user")){ %>
		YOU
		<%} else if(p.getWinner().equals("com")) { %>
		COM
		<%}else{ %>
		DRAW
		<%} %>
	</p>
	<a href="/janken/">もう一度遊ぶ</a>
</body>
</html>