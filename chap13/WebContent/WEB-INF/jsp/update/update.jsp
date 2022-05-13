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
			<h1>社員情報編集</h1>
			<form action="<%=request.getContextPath()%>/updateConfirm" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><c:out value="${emp.id}" /></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><input class="indata" type="text" name="name" value="<c:out value="${emp.name}" />"></td>
				</tr>
				<tr>
					<th>年齢</th>
					<td><input class="indata" type="text" name="age" value="<c:out value="${emp.age}" />"></td>
				</tr>
			</table>
			<input type="hidden" name="id" value="${emp.id}">
			<input class="submit-btn" type="submit" value="確認">
			</form>
			<a href="<%=request.getContextPath()%>/list">
				<button class="cancel-btn">戻る</button>
			</a>

		</main>
		<!-- #content -->
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>