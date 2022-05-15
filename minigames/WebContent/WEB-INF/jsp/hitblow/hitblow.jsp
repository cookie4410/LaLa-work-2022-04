<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="hitblow.util.Level" %>
<%@ page import="hitblow.model.bean.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hit and Blow</title>
 
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
	<c:if test="${!empty userLog.numLog[0]}">
	<div id="resultPanel">
		<div id="userResult">
			<h2>Your Attack!</h2>
			<p><c:out value="${userLog.numLog[0]}" /></p>
			<p><c:out value="${userLog.hitLog[0]}" /></p>
			<p><c:out value="${userLog.blowLog[0]}" /></p>
		</div>
		<div id="userResult">
			<h2>Opponent Attack!</h2>
			<p><c:out value="${comLog.numLog[0]}" /></p>
			<p><c:out value="${comLog.hitLog[0]}" /></p>
			<p><c:out value="${comLog.blowLog[0]}" /></p>
		</div>
	</div>
	</c:if>
	<div id="numFormWrapper">
		<h2 class="guideText">Enter the guessed code.</h2>
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
			<div class="panel ripple material-symbols-rounded" id="backspaceBtn">keyboard_backspace</div>
			<div class="panel numPanel ripple">0</div>
			<form action="<%=request.getContextPath()%>/hitblow" method="post" onsubmit="return checkSubmit()">
				<input name="num" type="hidden" id="numInput" />
				<button type="submit" class="panel ripple material-symbols-rounded" id="submitBtn">check</button>
			</form>
			<div class="panel ripple material-symbols-rounded" id="logOpenBtn">assignment</div>
		<!-- numPanelList -->
		</div>
	<!-- numFormWrapper -->
	</div>
	<div id="logPanel">
	<h2 id="logHeader">History log</h2>
		<div id="logWrapper">
			<div id="playerLog">
			<p>You</p>
				<dl>
					<c:forEach var="num" items="${userLog.numLog}" varStatus="loop">
						<dt><c:out value="${num}" /></dt>
						<dd>
							<c:out value="${userLog.hitLog[loop.index]}" /> - <c:out value="${userLog.blowLog[loop.index]}" />
						</dd>
					</c:forEach>
				</dl>
			</div>
			<div id="comLog">
			<p>Com</p>
				<dl>
					<c:forEach var="num" items="${comLog.numLog}" varStatus="loop">
						<dt><c:out value="${num}" /></dt>
						<dd>
							<c:out value="${comLog.hitLog[loop.index]}" /> - <c:out value="${comLog.blowLog[loop.index]}" />
						</dd>
					</c:forEach>
				</dl>
			</div>
		</div>
		<div class="panel ripple material-symbols-rounded" id="logCloseBtn">close</div>
	</div>

	</main>
	
	<jsp:include page="../common/footer.jsp" />
	<script src="<%=request.getContextPath()%>/js/hitblow/common.js"></script>
	<script src="<%=request.getContextPath()%>/js/hitblow/numForm.js"></script>
	<script src="<%=request.getContextPath()%>/js/hitblow/hitblow.js"></script>
</body>
</html>