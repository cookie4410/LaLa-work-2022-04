<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Const" %>
<aside id="subContent">
	<div id="menu-line"><div id="menu-btn">メニュー</div></div>
	<nav id="menu" class="no-disp">
		<ul>
			<li><a href="<%=request.getContextPath()%>/newEmp">新規登録</a></li>
			<li>
				<form action="<%=request.getContextPath()%>/searchId" method="post">
					<input class="search-box" type="search" name="id" placeholder="社員ID">
					<button class="no-button" type="submit"><%=Const.IMG_FIND%></button>
				</form>
			</li>
			<li>
				<form action="<%=request.getContextPath()%>/searchName" method="post">
					<input class="search-box" type="search" name="name" placeholder="社員名">
					<button class="no-button" type="submit"><%=Const.IMG_FIND%></button>
				</form>
			</li>
		</ul>
	</nav>
</aside>