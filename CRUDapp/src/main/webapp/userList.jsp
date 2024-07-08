<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.co.model.User"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>一覧・削除</title>
		<style>
			body{
				text-align: center;
			}
			table {
				border-collapse: collapse;
				width: 50%;
				margin: 0 auto;
			}
		</style>
	</head>
	<body>
		
		<h2 style="color:#FF99FF;"/*桃色を指定*/>User List</h2>
		<!-- 論理削除済みレコードを一括で復元するボタン -->
		<div style="text-align: right;">
			<form action="userRestore" method="post">
				<button type="submit">Restore Soft-Deleted Records</button>
			</form>
		</div>
		<table border="2">
			<tr>
				<th>User No</th>
				<th>User ID</th>
				<th>User Name</th>
<!-- 				<th>User Password</th> -->
<!-- 				<th>User Birthday</th> -->
				<th>Edit</th>
				<th>Delete</th>
				<th>Delete_v1</th>
			</tr>
			<%
			List<User> userList = (List<User>) request.getAttribute("userList");
			%>
			<%
			if (userList != null) {
			%>
			<%
			for (User user : userList) {
			%>
			<tr>
				<td><%=user.getUserNo()%></td>
				<td><%=user.getUserId()%></td>
				<td><%=user.getUserName()%></td>
<%-- 				<td><%= user.getUserPassword() %></td> --%>
<%-- 				<td><%= user.getUserBirthday() %></td> --%>
				<!-- Edit ボタン -->
				<td><a href="userEdit?userId=<%=user.getUserId()%>">Edit</a></td>
				<!-- Delete ボタン -->
				<td><a href="userDelete?userId=<%=user.getUserId()%>">Delete</a></td>
				<!-- Delete ボタン -->
				<td><a href="userDelete_v1?userNo=<%=user.getUserNo()%>">Delete_v1</a></td>
			</tr>
			<%
			}
			%>
			<%
			} else {
			%>
			<tr>
				<td colspan="7">No users available.</td>
			</tr>
			<%
			}
			%>
			</table>
			<div style="display:inline-flex">
				<form name = "A1" action="login.jsp" method="post">
					<button type="submit">Logout</button>
				</form>
				<form action="userAdd.jsp" method="post">
					<button type="submit">Add</button>
				</form>
			</div>
	</body>
</html>
