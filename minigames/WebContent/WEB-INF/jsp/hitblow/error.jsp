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
		<div class="center">
			<h1 style="font-size:120px;text-align:center;margin-bottom:100px;">Error!</h1>
			<p style="font-size:40px;text-align:center;margin-bottom:240px;">予期しないエラーが発生しました。</p>
			<div style="display:flex;justify-content: center;">
				<div class="panel ripple material-symbols-rounded" id="restartBtn">refresh</div>
				<div class="panel ripple material-symbols-rounded" id="homeBtn">home</div>
			</div>
		</div>
	</main>
	
	<jsp:include page="../common/footer.jsp" />
	<script src="<%=request.getContextPath()%>/js/hitblow/common.js"></script>
	<script src="<%=request.getContextPath()%>/js/hitblow/gameset.js"></script>
</body>
</html>