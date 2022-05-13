<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hitblow.util.Level" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hit and Blow</title>
<link rel="stylesheet" href="https://fonts.sandbox.google.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/hitblow.css">
</head>
<body>
	<header>
		<h1>Hit and Blow</h1>
	</header>
	<jsp:include page="../common/aside.jsp" />
	
	<main>
		<div id="ansPanelList">
			<div class="ansPanel">1</div>
			<div class="ansPanel">3</div>
			<div class="ansPanel"></div>
		</div>
		<div id="numPanelList">
			<div class="panel numPanel">1</div>
			<div class="panel numPanel">2</div>
			<div class="panel numPanel">3</div>
			<div class="panel numPanel">4</div>
			<div class="panel numPanel">5</div>
			<div class="panel numPanel">6</div>
			<div class="panel numPanel">7</div>
			<div class="panel numPanel">8</div>
			<div class="panel numPanel">9</div>
			<div class="panel material-symbols-rounded" id="backspaceBtn">keyboard_backspace</div>
			<div class="panel numPanel">0</div>
			<form action="" method="post">
				<button type="submit" class="panel material-symbols-rounded" id="submitBtn">check</button>
			</form>
			<div class="panel material-symbols-rounded" id="changeLevelBtn">assignment</div>
		</div>
	</main>
	
	<jsp:include page="../common/footer.jsp" />
	<script src="<%=request.getContextPath()%>/js/hitblow.js"></script>
</body>
</html>