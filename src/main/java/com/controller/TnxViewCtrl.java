package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LibraryInfoDao;
import com.dto.BookTnxDto;


@WebServlet("/TnxView")
public class TnxViewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Transaction view doget starts");

		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String bookId = request.getParameter("bookId");
		BookTnxDto bookTnxDto=new BookTnxDto();
		bookTnxDto.setBookId(bookId);
		String action = request.getParameter("buttonaction");
		System.out.println("Action :"+action);

		String[] rowKey = request.getParameterValues("rowKey");
		RequestDispatcher rd=null;
		boolean status=false;
		if(action.equalsIgnoreCase("Add")) {

			rd=request.getRequestDispatcher("BookTransaction.jsp");		

		}else if(action.equalsIgnoreCase("DeleteAll")) {
			status = LibraryInfoDao.deleteAll();
		}
		else 	if(action.equalsIgnoreCase("Update"))
		{
			rd=request.getRequestDispatcher("BookTransaction.jsp");		

		}else if(action.equalsIgnoreCase("Del")) {
			status = LibraryInfoDao.deleteTnx(bookId);
		}
		if(status) {
			System.out.println("viewAll");
			List<BookTnxDto> bookTnxList = LibraryInfoDao.viewBookTnx();
			session.setAttribute("bookTnxList", bookTnxList);
			rd=request.getRequestDispatcher("BookTnxView.jsp");

		}

rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
