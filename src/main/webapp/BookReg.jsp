<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
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
	<form action="BookReg" method="post">
		<table align="center"
			style="border: 2px solid #e8e8e8; margin-top: 100px">
			<b><tr>
					<td colspan="3" align="center"
						style="background: #969696; border: 2px solid #e8e8e8">Add
						Book</td>
				</tr>
				<tr>
					<td>BookId</td>
					<td>:</td>
					<td><input type="text" name="BookId" id="BookId"></td>
				</tr>
				<tr>
					<td>BookGroupId</td>
					<td>:</td>
					<td><input type="text" name="BookGroupId" id="BookGroupId"></td>
				</tr>

				<tr>
					<td>BookName</td>
					<td>:</td>
					<td><input type="text" name="BookName" id="BookName"></td>
				</tr>
				<tr>
					<td>ISBN Number</td>
					<td>:</td>
					<td><input type="text" name="ISBN" id="ISBN"></td>
				</tr>
				<tr>
					<td>Author</td>
					<td>:</td>
					<td><input type="text" name="Author" id="Author"></td>
				</tr>
				<tr>
					<td>Category</td>
					<td>:</td>
					<td><input type="text" name="Category" id="Category"></td>
				</tr>
				<tr>
					<td>Status</td>
					<td>:</td>
					<td><select id="status" name="status">
							<option value="available" selected>Available</option>
							<option value="not available">Not available</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						name="buttonaction" value="Back"> <input type="submit"
						name="buttonaction" value="Add"></td>
				</tr></b>
		</table>
	</form>

</body>
</html>