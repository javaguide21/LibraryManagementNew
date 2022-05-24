<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dto.BookRegDto"%>
<%@page import="java.util.*"%>


<%
List<BookRegDto> booksList = new ArrayList<>();

if (session.getAttribute("memberList") != null) {
	booksList = (List<BookRegDto>) session.getAttribute("bookList");

} else {
	booksList = new ArrayList<>();

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
					<td colspan="10" align="center"
						style="background: #969696; border: 2px solid #e8e8e8">List
						Of Books</td>
				</tr>
				<tr>
					<td align="center" colspan="10"><input type="submit"
						name="buttonaction" value="Add"> <input type="submit"
						name="buttonaction" value="DeleteAll"></td>
				</tr>
				<tr>
					<td></td>
					<td>BookId</td>
					<td>BookGroupId</td>
					<td>BookName</td>
					<td>ISBN Number</td>
					<td>Author</td>
					<td>Category</td>
					<td>Status</td>
					<td colspan="2"></td>
				</tr> <%
 for (BookRegDto bookList : booksList) {
 %>
				<tr>
					<td><input type="checkbox" name="rowKey"
						value=<%=bookList.getBookId()%>></td>

					<td><%=bookList.getBookId()%></td>
					<td><%=bookList.getBookGroupId()%></td>
					<td><%=bookList.getBookName()%></td>
					<td><%=bookList.getiSBNNo()%></td>
					<td><%=bookList.getAuthor()%></td>
					<td><%=bookList.getCategory()%></td>

					<td><%=bookList.getStatus()%></td>


					<td><a
						href="Update?bookId=<%=bookList.getBookId()%>&buttonaction=Update">Edit</td>
					<td><a
						href="Delete?bookId=<%=bookList.getBookId()%>&buttonaction=Del">Delete</td>
				</tr>
			</b>
			<%
			}
			%>
		</table>
	</form>

</body>
</html>