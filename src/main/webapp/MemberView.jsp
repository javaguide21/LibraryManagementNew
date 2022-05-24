<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dto.MmbrRegDto"%>
<%@page import="java.util.*"%>


<%
List<MmbrRegDto> memberList = new ArrayList<>();

if (session.getAttribute("memberList") != null) {
	memberList = (List<MmbrRegDto>) session.getAttribute("memberList");

} else {
	memberList = new ArrayList<>();

}
%>
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
	<form action="" method="post">

		<h1 align="center">LIBRARY MANAGEMENT</h1>

		<table align="center"
			style="border: 2px solid #e8e8e8; margin-top: 100px">
			<b>
				<tr>
					<td colspan="9" align="center"
						style="background: #969696; border: 2px solid #e8e8e8">List
						Of Members</td>
				</tr>
				<tr>
					<td align="center" colspan="9"><input type="submit"
						name="buttonaction" value="Add"> <input type="submit"
						name="buttonaction" value="DeleteAll"></td>
				</tr>
				<tr>
					<td></td>
					<td>MemberId</td>
					<td>MemberName</td>
					<td>MemberAddress</td>
					<td>MemberType</td>

				</tr> <%
					for (MmbrRegDto mmbrList : memberList) {
					%>
				<tr>

					<td><input type="checkbox" name="rowKey"
						value=<%=mmbrList.getMemberID()%>></td>

					<td><%=mmbrList.getMemberID()%></td>
					<td><%=mmbrList.getMemberName()%></td>
					<td><%=mmbrList.getAddress()%></td>
					<td><%=mmbrList.getMemberType()%></td>

					<td><a
						href="Update?memberId=<%=mmbrList.getMemberID()%>&buttonaction=Update">Edit</td>
					<td><a
						href="Delete?memberId=<%=mmbrList.getMemberID()%>&buttonaction=Del">Delete</td>

				</tr> <%
					}
					%>
			</b>

		</table>
	</form>

</body>
</html>