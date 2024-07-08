<!--※今回はログイン制御は記載しておりません-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
		<style>
			body {
				text-align: center;
			}

			label {
				display: inline-block;
				width: 100px;
				text-align: right;
				margin-right: 10px;
			}
		</style>
	</head>
	<body>
		<h2 style="color:skyblue;"/*水色を指定*/>Login</h2>

<!--	ログイン画面の表示処理 -->
		<form style="color:skyblue" action="user" method="post">
			<input type="hidden" name="action" value="login">
			<label for="username">Username:</label>
			<input type="text" id="username" name="username" required>
			<br>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" required>
			<br>
			<button type="submit">Login</button>
		</form>
		<br>

<!--	ユーザー追加画面へ遷移処理 -->
		<a href="userAdd.jsp">Sign Up</a>

		<br>
		<%
		if (request.getAttribute("error") != null) {
		%>
		<p style="color: red;"><%=request.getAttribute("error")%></p>
		<%
		}
		%>
	</body>
</html>