<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集</title>
<style>
body {
	text-align: center;
}

label {
	display: inline-block;
	width: 200px;
	text-align: right;
	margin-right: 10px;
}
</style>
</head>
<body>

	<h2 style="color: #3FFF00;" /*黄緑色を指定* />
	Edit User
	</h2>

	<%
    Object userToEditObject = request.getAttribute("userToEdit");
    if (userToEditObject instanceof User) {
        User userToEdit = (User) userToEditObject;
%>

	<form action="userEdit" method="post">
		<label for="userId">User ID:</label> <input type="text" id="userId"
			name="userId" value="<%= userToEdit.getUserId() %>" required>
		<br> <label for="userName">User Name:</label> <input type="text"
			id="userName" name="userName" value="<%= userToEdit.getUserName() %>"
			required> <br> <label for="userPassword">User
			Password:</label> <input type="password" id="userPassword"
			name="userPassword" value="<%= userToEdit.getUserPassword() %>"
			required> <br>
		<!--    <label for="userBirthday">User Birthday(閲覧用):</label>-->
		<!--    <input type="text" id="userBirthday" name="userBirthday" value="<%= userToEdit.getUserBirthday() %>" style="pointer-events: none;" readonly>-->
		<!--    <br>-->
		<label for="userBirthday">User Birthday:</label> <input type="date"
			id="userBirthday" name="userBirthday"
			value="<%= userToEdit.getUserBirthday() %>" required> <br>
		<br>
		<button type="submit">Save</button>
	</form>

	<%
    } else {
        // userToEditがUserクラスのインスタンスでない場合のエラー処理
%>
	<p>Error: Unable to retrieve user information.</p>
	<%
    }
%>

	<!-- Get処理 -->
	<%--
	<br>
	<a href="<%= request.getContextPath() %>/user?action=list">Back</a>
	<br>
	--%>

	<!-- Post処理 -->
	<div style="display: inline-flex">
		<form action="user" method="post">
			<input type="hidden" name="action" value="login">
			<button type="submit">Back</button>
		</form>
		<form action="login.jsp" method="post">
			<button type="submit">Logout</button>
		</form>
	</div>

</body>
</html>
