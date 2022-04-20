<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.PlayResult" %>
<%
	PlayResult result = (PlayResult) request.getAttribute("result");
	String[] hands = {"グー", "チョキ", "パー"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん結果</title>
</head>
<body>
	<h1>じゃんけん結果</h1>
	<p>あなた: <%=hands[result.getUser()] %></p>
	<p>わたし: <%=hands[result.getCom()] %>
	<p>勝者:
	<% if (result.getWinner().equals("user")) { %>
		あなた
	<% } else if (result.getWinner().equals("com")) { %>
		わたし
	<% } else if (result.getWinner().equals("draw")) { %>
		引き分け
	<% } %>
	</p>
	<p><a href="/janken/">もう一回する</a></p>
</body>
</html>