<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.dto.Address" %>
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
	<form action="MbrReg" method="post">
		<table align="center"
			style="border: 2px solid #e8e8e8; margin-top: 100px; border-collapse: collapse">
			<b>
				<tr>
					<td colspan="3" align="center"
						style="background: #969696; border: 2px solid #e8e8e8">Member
						Registration</td>
				</tr>
				<tr>
					<td>MemberId</td>
					<td>:</td>
					<td><input type="text" name="memberId" id="memberId" required></td>
				</tr>
				<tr>
					<td>MemberName</td>
					<td>:</td>
					<td><input type="text" name="memberName" id="memberName"
						required></td>
				</tr>
				<tr>
					<td colspan="3">MemberAddress:</td>
				</tr>
				<tr>
					<td style="border-top:1px solid white"  colspan="3"></td>
					
				</tr>

				<tr>
					<td>StreetNo : <input type="text" name="StreetNo"
						id="StreetNo" required></td>
					<td></td>
					<td>StreetName:<input type="text" name="StreetName"
						id="StreetName" required></td>
				</tr>
				<tr>
					<td>City&nbsp;:&nbsp;<input type="text" name="City" id="City"
						required></td>
					<td></td>
					<td>District&nbsp;:&nbsp;<input type="text" name="District"
						id="District" required></td>
					</td>
				</tr>
				<tr>
					<td>Pincode&nbsp;:&nbsp;<input type="text" name="Pincode"
						id="Pincode" required></td>
					<td></td>
					<td>Country&nbsp;:&nbsp;<input type="text" name="Country"
						id="Country" value=<%=Address.COUNTRY %>>
					</td>
				</tr>
				<tr>
					<td style="border-top:1px solid white"  colspan="3"></td>
					
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
						name="buttonaction" value="Back">
						<input type="submit"
						name="buttonaction" value="Add"></td>
				</tr>
			</b>
		</table>
	</form>

</body>
</html>