<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ミニゲーム集</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<script src="<%=request.getContextPath()%>/js/common/jquery-3.4.1.min.js"></script>
</head>
<body>
	<header>
		<h1>ミニゲーム集</h1>
	</header>
	<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
	
	<main>
		<dl>
			<dt><a href="/minigames/hitblowStart">Hit and Blow</a></dt>
			<dd>CPUと対戦する数当てゲーム</dd>
			<dd><a href="/minigames/hitblowHowto">How to play</a></dd>
		</dl>
	</main>
	
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>