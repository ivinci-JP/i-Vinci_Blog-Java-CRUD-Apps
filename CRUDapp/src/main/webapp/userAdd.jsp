<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jp.co.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>追加</title>
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

<h2 style="color:#FFFF00;"/*黃色を指定*/>Add User</h2>

<form action="userAdd" method="post">
    <label for="userId">User ID:</label>
    <input type="text" id="userId" name="userId" required>
    <br>
    <label for="userName">User Name:</label>
    <input type="text" id="userName" name="userName" required>
    <br>
    <label for="userPassword">User Password:</label>
    <input type="password" id="userPassword" name="userPassword" required>
    <br>
    <label for="userBirthday">User Birthday:</label>
    <input type="date" id="userBirthday" name="userBirthday"  required>
    <br>
    <button type="submit">UserRegistration</button>
</form>

<br>
<div style="display:inline-flex">
<%--
	<a href="<%= request.getContextPath() %>/user?action=list">Back</a>
	<form action="<%= request.getContextPath() %>/user?action=login" method="post">
		<button type="submit">Logout</button>
	</form>
--%>
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
