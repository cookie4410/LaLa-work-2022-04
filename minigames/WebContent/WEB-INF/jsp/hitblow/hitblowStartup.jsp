<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hitblow.util.Level" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hit and Blow</title>
 <!-- 
<link rel="preload" as="font" href="https://fonts.sandbox.google.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0" />
 -->
 
 <link rel="preload" as="style" onload="this.rel = 'stylesheet'" href="https://fonts.sandbox.google.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/hitblow.css">
<script src="<%=request.getContextPath()%>/js/common/jquery-3.4.1.min.js"></script>
</head>
<body>
	<header>
		<h1>Hit and Blow</h1>
	</header>
	<jsp:include page="../common/aside.jsp" />
	
	<main>
	<div id="levelFormWrapper" class="active">
		<div id="levelForm">
			<h2>レベルを選択</h2>
			<% for(Level level : Level.values()){ %>
				<button class="levelBtn"><%=level %></button>
			<% } %>
		</div>
	</div>
	<div id="numFormWrapper">
		<div id="ansPanelList">
			<div class="ansPanel" id="selected"></div>
			<div class="ansPanel"></div>
			<div class="ansPanel"></div>
		</div>
		<div id="numPanelList">
			<div class="panel numPanel ripple">1</div>
			<div class="panel numPanel ripple">2</div>
			<div class="panel numPanel ripple">3</div>
			<div class="panel numPanel ripple">4</div>
			<div class="panel numPanel ripple">5</div>
			<div class="panel numPanel ripple">6</div>
			<div class="panel numPanel ripple">7</div>
			<div class="panel numPanel ripple">8</div>
			<div class="panel numPanel ripple">9</div>
			<div class="panel material-symbols-rounded" id="backspaceBtn">keyboard_backspace</div>
			<div class="panel numPanel ripple">0</div>
			<form action="<%=request.getContextPath()%>/hitblow" method="post" onsubmit="return checkSubmit()">
				<input type="hidden" id="levelInput" />
				<input type="hidden" id="numInput" />
				<button type="submit" class="panel material-symbols-rounded" id="submitBtn">check</button>
			</form>
			<div class="panel material-symbols-rounded" id="changeLevelBtn">redo</div>
		<!-- numPanelList -->
		</div>
	<!-- numFormWrapper -->
	</div>
	</main>
	
	<jsp:include page="../common/footer.jsp" />
	<script src="<%=request.getContextPath()%>/js/hitblowStartup.js"></script>
</body>
</html>