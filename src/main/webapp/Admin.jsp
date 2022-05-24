<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style>
td {
	
	padding: 10px;
	background: #ababab;
	font-size: 20px;
}
</style>
</head>
<body>
	<form action="Admin" method="post">
		<table align="center"
			style=" margin-top: 100px;width:50%">
			<b>
				<tr>
					<td colspan="3" align="center"
						style="background: #969696; border: 2px solid #e8e8e8">LibraryAdministration</td>
				</tr>
				<tr>
					<td align= "center"><input type="submit" name="buttonaction" value="MemberList" ></td>
					<td align= "center"><input type="submit" name="buttonaction" value="BookList" ></td>
					<td align= "center"><input type="submit" name="buttonaction" value="BookTnxList" ></td>
				
				</tr>
			</b>
		</table>
	</form>

</body>
</html>