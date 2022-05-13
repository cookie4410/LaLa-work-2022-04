<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GameData" %>
<%
GameData gd = (GameData) session.getAttribute("gd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>High and Low</title>
</head>
<body>
	<h1>High and Low</h1>
	<p>1～99の数字を当てよう！</p>
	<form action="play" method="post">
		<input type="number" name="num">
		<input type="submit" value="送信">
	</form>
	<%if(request.getAttribute("check") != null && !(boolean)request.getAttribute("check")){ %>
		<p>[Error!]無効な入力です。</p>
	<%}else{
		if(gd != null && gd.getResult() == 10) {
			session.invalidate();%>
			<p>
				正解！！<br>
				<%=gd.getCount() %>回で正解できました！
			</p>
			<button onclick="location.href='/highAndLow/play'">もう一度遊ぶ</button>
		<%} else {
			if(gd != null && gd.getResult() == -1){ %>
				<p>もっと小さいよ</p>
			<%} else if(gd != null && gd.getResult() == 1) { %>
				<p>もっと大きいよ</p>
			<%} %>
			<ul>
			<% if(gd.getLog() != null){
				for(String log: gd.getLog()){ %>
					<li><%=log %></li>
				<%}
			} %>
		</ul>
		<%}
	} %>
</body>
</html>