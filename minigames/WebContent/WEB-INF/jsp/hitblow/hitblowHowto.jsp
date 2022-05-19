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
	
	<main id="howto">
		<div>
			<h2>How to Play</h2>
			<dl>
				<dt>Introduction</dt>
				<dd>お互いに3桁の数字を決め、より早く相手の数字を推測することを目指す対戦ゲームです。</dd>
				<dt>Description</dt>
				<dd>
					<dl>
						<dt>Level</dt>
						<dd>
							<p>- EASY<br>
								あてずっぽうで攻撃します。<br>
								ほぼ負けることはないでしょう。
							</p>
							<p>- NORMAL<br>
							推理をもとに攻撃します。<br>
							こちらも推理力を発揮する必要がありそうです。
							</p>
							<p>- HARD<br>
							非常に賢く、最善手に近い攻撃を繰り返します。<br>
							勝つためには運の要素も必要かもしれません。
							</p>
							<p>- EXPERT<br>
							賢い上に、運をも味方につけた最強の敵です。<br>
							生半可な実力では引き分けすら難しいでしょう。
							</p>
						</dd>
						<dt>Secret Code</dt>
						<dd>ゲーム開始前に、秘密の数字「秘密鍵」を決める必要があります。<br>
							「秘密鍵」には<strong>同じ数字を含んではならない</strong>というルールがあります。</dd>
						<dt>Attack</dt>
						<dd>ゲームが始まるとお互いに攻撃を繰り返すことになります。<br>
							攻撃は、相手の「秘密鍵」だと思う数字を宣言して行います。<br>
							もし外れたとしても安心してください。<br>
							攻撃の結果に応じてヒントが与えられます。</dd>
						<dt>Hit and Blow</dt>
						<dd>攻撃の結果から、「Hit」と「Blow」という2つのヒントが与えられます。<br>
							Hit  - 攻撃宣言と相手の秘密鍵の、「場所」も「数字」も一致した数。<br>
							Blow - 攻撃宣言と相手の秘密鍵の、「場所」は違うが「数字」が含まれている数。<br>
							<p><span>e.g.</span><br>
								[123] &lt;- [139] : 1 Hit 1 Blow<br>
								[123] &lt;- [923] : 2 Hit 0 Blow<br>
								[123] &lt;- [321] : 1 Hit 2 Blow<br></p></dd>
						<dt>Conclusion</dt>
						<dd>相手の秘密鍵を明らかにする、つまり先に3Hitを達成したプレイヤーが勝利です。<br>
							同じターンに両プレイヤーが3Hitを達成した場合は引き分けとなります。</dd>
					</dl>
				</dd>
				<dt>Interface</dt>
				<dd>
					<div class="panel material-symbols-rounded" id="backspaceBtn">keyboard_backspace</div>
					<p>Backspace - 一文字消す（入力済みの数字をタップでカーソル位置を移動できます）。</p>
					<div class="panel material-symbols-rounded" id="submitBtn">check</div>
					<p>Submit - 入力を確定し、送信します。</p>
					<div class="panel material-symbols-rounded" id="logOpenBtn">assignment</div>
					<p>HistoryLog - 攻撃の履歴を開きます。</p>
				</dd>
			</dl>
		</div>
	</main>
	
	<jsp:include page="../common/footer.jsp" />
	<script src="<%=request.getContextPath()%>/js/hitblow/common.js"></script>
	<script src="<%=request.getContextPath()%>/js/hitblow/gameset.js"></script>
</body>
</html>