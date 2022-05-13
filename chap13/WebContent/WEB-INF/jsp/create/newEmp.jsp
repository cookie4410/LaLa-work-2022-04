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
			<h1>新規登録</h1>

			<form action="<%=request.getContextPath()%>/confirm" method="post">
				<table>
					<tr>
						<th>ID</th>
						<td><input class="indata" type="text" name="id"></td>
					</tr>
					<tr>
						<th>名前</th>
						<td><input class="indata" type="text" name="name"></td>
					</tr>
					<tr>
						<th>年齢</th>
						<td><input class="indata" type="text" name="age"></td>
					</tr>
				</table>
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