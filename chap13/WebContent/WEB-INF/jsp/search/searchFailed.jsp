<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ社員管理システム</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />

	<div id="content">
		<jsp:include page="../common/aside.jsp" />

		<main id="main">
			<h1>社員情報検索</h1>
			<h2>「<c:out value="${key}" />」の検索結果</h2>

			<p>条件に一致する項目は見つかりませんでした。</p>
			<a href="<%=request.getContextPath()%>/list">
				<button class="cancel-btn">戻る</button>
			</a>

		</main>
		<!-- #content -->
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>