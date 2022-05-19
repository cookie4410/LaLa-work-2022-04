<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="glicote.util.Hands" %>
<%@ page import="glicote.model.bean.GameDataBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぐりこ手線ゲーム</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/glicote.css">
<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
<script src="<%=request.getContextPath()%>/js/common/jquery-3.4.1.min.js"></script>
</head>
<body>
	<header>
		<h1>ぐりこ手線ゲーム</h1>
	</header>
	<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
	<main>
	<div id="gameWrapper">
		<div id="route">
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
			<div class="station"></div>
		</div>
		<div id="hands">
			<% for(Hands hand : Hands.values()){ %>
				<form id="<%=hand.name()%>Form" action="<%=request.getContextPath()%>/glicote" method="post">
					<input type="hidden" name="hand" value="<%=hand.name()%>" />
					<div onClick="document.forms['<%=hand.name()%>Form'].submit();"><%=hand.getTag()%></div>
				</form>
			<% } %>
		</div>
	</div>
	</main>

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script type="text/javascript">
		let path = "<%=request.getContextPath()%>/glicote"
		let userStep = <c:out value="${gameData.userStep}" />;
		let comStep = <c:out value="${gameData.comStep}" />;
		let winnerHand = <c:out default="undefined" escapeXml="true" value="${empty gameData.winnerHand ? 'undefined' : gameData.winnerHand}" />;
	</script>
	<script src="<%=request.getContextPath()%>/js/glicote/glicote.js"></script>
</body>
</html>
