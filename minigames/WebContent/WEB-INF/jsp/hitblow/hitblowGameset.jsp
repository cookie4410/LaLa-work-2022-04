<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	
	<div id="resultPanel" class="center active">
		<div id="userResult" class="center active">
			<div class="resultHeader center">
				<h2>Your Attack!</h2>
			</div>
			<div class="result">
				<p><fmt:formatNumber minIntegerDigits="3" value="${userLog.numLog[0]}" /></p>
				<p><span><c:out value="${userLog.hitLog[0]}" /></span>
				<span><c:out value="${userLog.blowLog[0]}" /></span></p>
			</div>
		</div>
		<div id="comResult" class="center">
			<div class="resultHeader center">
				<h2>Opponent Attack!</h2>
			</div>
			<div class="result">
				<p><fmt:formatNumber minIntegerDigits="3" value="${comLog.numLog[0]}" /></p>
				<p><span><c:out value="${comLog.hitLog[0]}" /></span>
				<span><c:out value="${comLog.blowLog[0]}" /></span></p>
			</div>
		</div>
		<div id="gameResult" class="center">
			<div class="resultHeader center">
				<h2>Game Set!</h2>
			</div>
			<div class="result">
				<p>The winner is...</p>
				<p><span>
					<c:choose>
						<c:when test="${result == 1}">YOU!</c:when>
						<c:when test="${result == 2}">COM!</c:when>
						<c:when test="${result == 3}">BOTH OF YOU!</c:when>
					</c:choose>
				</span></p>
			</div>
		</div>
	<!-- #resultPanel -->
	</div>
	<div id="gamesetPanel" class="center">
	<h2 class="popup"><span>RESULT</span></h2>
		<div id="winlose">
			<p class="popup"><span>
			<c:choose>
				<c:when test="${result == 1}">WIN!</c:when>
				<c:when test="${result == 2}">LOSE!</c:when>
				<c:when test="${result == 3}">DRAW!</c:when>
			</c:choose>
			</span></p>
		</div>
		<div id="secretCodes">
			<h3 class="popup"><span>SECRET CODE</span></h3>
			<p class="popup"><span>YOU: <fmt:formatNumber minIntegerDigits="3" value="${gameData.userNum}" /></span></p>
			<p class="popup"><span>COM: <fmt:formatNumber minIntegerDigits="3" value="${gameData.comNum}" /></span></p>
		</div>
		<div id="durationTime">
			<h3 class="popup"><span>DURATION TIME</span></h3>
			<p class="popup"><span><c:out value="${time}" /></span></p>
		</div>
		<div id="buttons">
			<div class="panel ripple material-symbols-rounded" id="logOpenBtn">assignment</div>
			<div class="panel ripple material-symbols-rounded" id="restartBtn">refresh</div>
			<div class="panel ripple material-symbols-rounded" id="homeBtn">home</div>
		</div>
	</div>

	<div id="logPanel">
	<h2 id="logHeader">History log</h2>
		<div id="logWrapper">
			<div id="playerLog">
			<p>You</p>
				<dl>
					<c:forEach var="num" items="${userLog.numLog}" varStatus="loop">
						<dt><fmt:formatNumber minIntegerDigits="3" value="${num}" /></dt>
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
						<dt><fmt:formatNumber minIntegerDigits="3" value="${num}" /></dt>
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
	<script src="<%=request.getContextPath()%>/js/hitblow/gameset.js"></script>
</body>
</html>