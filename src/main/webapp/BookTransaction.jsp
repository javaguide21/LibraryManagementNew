<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dto.BookTnxDto"%>
<%@page import="java.util.*"%>

<%
BookTnxDto bookTnxDto = new BookTnxDto();
if (session.getAttribute("bookTnx") != null) {
	bookTnxDto = (BookTnxDto) session.getAttribute("bookTnx");
} else {
	bookTnxDto = new BookTnxDto("",0,new Date(), new Date(), new Date());
	System.out.println("bookTnxDto is null");

}
%>
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
	<form action="BookTnx" method="post">
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
					<td><input type="text" name="BookId" id="BookId"
						value=<%=bookTnxDto.getBookId()%>></td>
				</tr>
				<tr>
					<td>MemberId</td>
					<td>:</td>
					<td><input type="number" name="MemberId" id="MemberId"
						value=<%=bookTnxDto.getMemberId()%>></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" name="buttonaction" value="Retrieve"></td>
				</tr>
				<tr>
					<td>BorrowDate</td>
					<td>:</td>
					<td><input type="date" name="BorrowDate" id="BorrowDate"
						value=<%=bookTnxDto.getBorrowdate()%>></td>
				</tr>
				<tr>
					<td>ReturnDate</td>
					<td>:</td>
					<td><input type="date" name="ReturnDate" id="ReturnDate"
						value=<%=bookTnxDto.getReturndate()%>></td>
				</tr>
				<tr>
					<td>DueDate</td>
					<td>:</td>
					<td><input type="date" name="DueDate" id="DueDate"
						value=<%=bookTnxDto.getDuedate()%>></td>
				</tr>

				<tr>
					<td colspan="3" align="center">
					<input type="submit"
						name="buttonaction" value="AddTnx/UpdateTnx"></td>
				</tr></b>
		</table>
	</form>

</body>
</html>