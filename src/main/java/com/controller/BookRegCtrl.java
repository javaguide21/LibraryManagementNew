package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LibraryInfoDao;
import com.dto.BookRegDto;


@WebServlet("/BookReg")
public class BookRegCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Book Registration  doGet Starts");
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String button = request.getParameter("buttonaction");
		System.out.println("Action : " + button);
		RequestDispatcher rd = null;
		if (button.equalsIgnoreCase("Back")) {
			rd = request.getRequestDispatcher("index.jsp");
		} else if (button.equalsIgnoreCase("Add")) {

			//public MmbrRegDto reg() {
			String bookId = request.getParameter("BookId");
			String bookGroupId = request.getParameter("BookGroupId");
			int bkGrpId=Integer.parseInt(bookGroupId);
			String bookName = request.getParameter("BookName");
			String iSBN = request.getParameter("ISBN");
			String author = request.getParameter("Author");
			String category = request.getParameter("Category");
			String status = request.getParameter("status");

			BookRegDto bookRegDto = new BookRegDto(bookId, bkGrpId, bookName, iSBN, author, category, status);
			session.setAttribute("bookRegDto", bookRegDto);
			//}
			//session.getAttribute("bookRegDto");
		boolean bkstatus = LibraryInfoDao.insertBook(bookRegDto);
			if(bkstatus) {
				out.println("<h1 style='color:green;margin-top:100px;'>"+bookId+" , was registered successfully</h1>");
				out.println("<h1 style='color:black;margin-top:120px;'><a href='index.jsp'>Home</a></h1>");

				rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
				} else {
				out.println("<h1 style='color:red;margin-top:100px;'>Error in Registration</h1>");
				rd = request.getRequestDispatcher("BookReg.jsp");
				rd.include(request, response);
				System.out.println("Error in Registration");
			}
		}//rd.forward(request, response);
		System.out.println("Book Registration doGet ends");


	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
