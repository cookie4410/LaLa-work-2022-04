<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="util.Const" %>
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
			<table>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>年齢</th>
				</tr>
				<c:forEach var="emp" items="${empList}">
				<tr>
					<td><c:out value="${emp.id}" /></td>
					<td><c:out value="${emp.name}" /></td>
					<td><c:out value="${emp.age}" /></td>
					<!-- 編集ボタン -->
					<td class="no-border">
						<form action="<%=request.getContextPath()%>/update" method="post">
							<input type="hidden" name="id" value="${emp.id}">
							<button class="no-button" type="submit"><%=Const.IMG_PENCIL%></button>
						</form>
					</td>
					<!-- 削除ボタン -->
					<td class="no-border">
						<form action="<%=request.getContextPath()%>/delete" method="post">
							<input type="hidden" name="id" value="${emp.id}">
							<button class="no-button" type="submit"><%=Const.IMG_TRASH%></button>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			<!-- 
			<form action="<%=request.getContextPath()%>/update" method="post">
				<input type="hidden" name="id" value="${emp.id}">
				<input class="submit2-btn" type="submit" value="編集">
			</form>
			<form action="<%=request.getContextPath()%>/delete" method="post">
				<input type="hidden" name="id" value="${emp.id}">
				<input class="submit-btn" type="submit" value="削除">
			</form>
			 -->
			<a href="<%=request.getContextPath()%>/list">
				<button class="cancel-btn">戻る</button>
			</a>

		</main>
		<!-- #content -->
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>