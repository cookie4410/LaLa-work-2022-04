<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
	<form action="/example/RegisterUser" method="post">
		<span>ログインID: </span>
		<input type="text" name="id"><br>
		<span>パスワード: </span>
		<input type="password" name="pass"><br>
		<span>名前: </span>
		<input type="text" name="name"><br>
		<input type="submit" value="確認">
	</form>
</body>
</html>