package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LibraryInfoDao;
import com.dto.BookTnxDto;
import com.util.CommonDate;

@WebServlet("/BookTnx")
public class BookTnxCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("book trnx  doGet Starts");

		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String bookId = request.getParameter("BookId");
		BookTnxDto bookTnxDto = new BookTnxDto();
		bookTnxDto.setBookId(bookId);

		String button = request.getParameter("buttonaction");
		System.out.println("Action : " + button);
		RequestDispatcher rd = null;

		if (button.equalsIgnoreCase("Retrieve")) {
			System.out.println("retrieve");
			bookTnxDto = LibraryInfoDao.retrieveTnx(bookTnxDto);
			System.out.println("======="+bookTnxDto.toString());
			session.setAttribute("bookTnx", bookTnxDto);
			rd = request.getRequestDispatcher("BookTransaction.jsp");
			rd.forward(request, response);
		}
		boolean status1 = LibraryInfoDao.idCheckTnx(bookId);
		if(status1) {

			if (button.equalsIgnoreCase("AddTnx/UpdateTnx")) {

				if (bookTnxDto!= null) {

					System.out.println("=========not null======");
					System.out.println("updating tnx details ");
					String memberId = request.getParameter("MemberId");
					int id = Integer.parseInt(memberId);
					String borrowdate = request.getParameter("BorrowDate");
					Date bwdt = CommonDate.getDate(borrowdate);
					String returndate = request.getParameter("ReturnDate");
					System.out.println(returndate);

					Date rwdt = CommonDate.getDate(returndate);
					System.out.println(rwdt);
					String duedate = request.getParameter("DueDate");
					Date duedt = CommonDate.getDate(duedate);
					bookTnxDto = new BookTnxDto(bookId, id, bwdt, rwdt, duedt);
					System.out.println(bookTnxDto.toString());
					boolean status = LibraryInfoDao.updateTnx(bookTnxDto);
					if (status) {
						out.println(
								"<h1 style='color:green;margin-top:100px;'>Hi,book was returned, you are updated transaction successfully</h1>");
						out.println("<h1 style='color:black;margin-top:120px;'><a href='index.jsp'>Home</a></h1>");
						rd = request.getRequestDispatcher("index.jsp");

						rd.include(request, response);
						System.out.println("update successful");
					} else {
						out.println(
								"<h1 style='color:green;margin-top:100px;'>update failure</h1>");

						System.out.println("update failure");
						rd = request.getRequestDispatcher("BookTransaction.jsp");
						rd.include(request, response);

					}

				} }}
		else {
			System.out.println("=========null");

			System.out.println("inserting tnx details ");
			String memberId = request.getParameter("MemberId");
			int	id = Integer.parseInt(memberId);
			String borrowdate = request.getParameter("BorrowDate");
			Date bwdt = CommonDate.getDate(borrowdate);
			String returndate = request.getParameter("ReturnDate");
			System.out.println(returndate);

			Date rwdt = CommonDate.getDate(returndate);
			System.out.println(rwdt);
			String duedate = request.getParameter("DueDate");
			Date duedt = CommonDate.getDate(duedate);
			bookTnxDto = new BookTnxDto(bookId, id, bwdt, rwdt, duedt);

			boolean status = LibraryInfoDao.insertTnx(bookTnxDto);
			System.out.println(status);
			if (status) {
				out.println("<h1 style='color:green;margin-top:100px;'>Hi, " + memberId
						+ "you are transacted successfully</h1>");
				out.println("<h1 style='color:black;margin-top:120px;'><a href='index.jsp'>Home</a></h1>");
				rd.include(request, response);

			} else {
				out.println("<h1 style='color:green;margin-top:100px;'> transaction failed</h1>");

				System.out.println("failed to insert");
				rd = request.getRequestDispatcher("BookTransaction.jsp");
				rd.include(request, response);

			}
		}



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
