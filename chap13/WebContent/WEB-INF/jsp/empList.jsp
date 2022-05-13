<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.Const" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>どこつぶ社員管理システム</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<jsp:include page="common/header.jsp" />
	
	<div id="content">
		<jsp:include page="common/aside.jsp" />
		
		<main id="main">
			<h1>社員一覧</h1>
			
			<table>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>年齢</th>
					<th class="no-border"></th>
					<th class="no-border"></th>
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
			<div id="pagenation">
				<ul>
					<li><a href="<%=request.getContextPath()%>/list?page=1">&lt;&lt;</a></li>
					<li><a href="<%=request.getContextPath()%>/list?page=${(page <= 1) ? 1 : page - 1}">&lt;</a></li>
					<c:forEach var="i" begin="1" end="${last}" step="1">
						<li><a href="<%=request.getContextPath()%>/list?page=${i}">${i}</a></li>
					</c:forEach>
					<li><a href="<%=request.getContextPath()%>/list?page=${(page >= last) ? last : page + 1}">&gt;</a></li>
					<li><a href="<%=request.getContextPath()%>/list?page=${last}">&gt;&gt;</a></li>
				</ul>
			</div>
		</main>
	<!-- #content -->
	</div>
	<jsp:include page="common/footer.jsp" />
</body>
</html>