<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style>
td {
	align: center;
	padding: 10px;
	background: #ababab;
	font-size: 20px;
}
</style>
</head>
<body>
	<form action="Login" method="post">
		<table align="center"
			style="border-collapse:collapse;border: 2px solid #e8e8e8; margin-top: 100px">
			<b>
				<tr>
					<td colspan="3" align="center"
						style="background: #969696; border: 2px solid #e8e8e8">Member
						Registration</td>
				</tr>
				<tr>
					<td>MemberId</td>
					<td>:</td>
					<td><input type="text" name="memberId" id="memberId"></td>
				</tr>
				<tr>
					<td>MemberType</td>
					<td>:</td>
					<td><select id="type" name="type">
							<option value="User">User</option>
							<option value="Admin">Admin</option>
					</select></td>
				</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit"
					name="buttonaction" value="Signup">
					<input type="submit"
					name="buttonaction" value="Login"></td>
			</tr>
			</b>
		</table>
	</form>

</body>
</html>