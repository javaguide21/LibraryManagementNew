<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dto.BookTnxDto"%>
<%@page import="java.util.*"%>
<%
List<BookTnxDto> bookTnxList=new ArrayList<>();
	if(session.getAttribute("bookTnxList")!=null){
		bookTnxList=(List<BookTnxDto>)session.getAttribute("bookTnxList");
	}else{
		 bookTnxList=new ArrayList<>();
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
	<form action="TnxView" method="post">

		<h1 align="center">LIBRARY MANAGEMENT</h1>

		<table align="center"
			style="border: 2px solid #e8e8e8; margin-top: 100px">
			<b>
				<tr>
					<td colspan="9" align="center"
						style="background: #969696; border: 2px solid #e8e8e8">List
						Of Books Transaction</td>
				</tr>
				<tr>
					<td align="center" colspan="9"><input type="submit"
						name="buttonaction" value="Add"> <input type="submit"
						name="buttonaction" value="DeleteAll"></td>
				</tr>
				<tr>
					<td></td>
					<td>BookId</td>
					<td>MemberId</td>
					<td>BorrowDate</td>
					<td>ReturnDate</td>
					<td>Duedate</td>
					<td colspan="2"></td>
				</tr> 
				<%for(BookTnxDto TnxList:bookTnxList) { %>
				<tr>
					<td><input type="checkbox" name="rowKey"
						value=<%=TnxList.getBookId()%>></td>

					<td><%=TnxList.getBookId()%></td>
					<td><%=TnxList.getMemberId()%></td>
					<td><%=TnxList.getBorrowdate()%></td>
					<td><%=TnxList.getReturndate()%></td>
					<td><%=TnxList.getBorrowdate()%></td>
										<td><a
						href="TnxView?bookId=<%=TnxList.getBookId()%>&buttonaction=Update">Edit</td>
					<td><a
						href="TnxView?bookId=<%=TnxList.getBookId()%>&buttonaction=Del">Delete</td>

					<%} %>
				</tr>
			</b>

		</table>
	</form>

</body>
</html>