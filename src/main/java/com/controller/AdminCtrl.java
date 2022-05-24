package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LibraryInfoDao;
import com.dto.BookRegDto;
import com.dto.BookTnxDto;
import com.dto.MmbrRegDto;

@WebServlet("/Admin")
public class AdminCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Adminpage doGet Starts");
		HttpSession session = request.getSession();
		String button = request.getParameter("buttonaction");
		System.out.println("Action : " + button);
		RequestDispatcher rd = null;
		if (button.equalsIgnoreCase("MemberList")) {
			System.out.println("All Member details ");
			List<MmbrRegDto> memberList = LibraryInfoDao.viewMember();
			session.setAttribute("memberList", memberList);
			rd = request.getRequestDispatcher("MemberView.jsp");
		} 
		else if (button.equalsIgnoreCase("BookList")) {
			System.out.println("All book details ");
			List<BookRegDto> bookList = LibraryInfoDao.viewBookDetails();
			session.setAttribute("bookList", bookList);
			rd = request.getRequestDispatcher("BookView.jsp");
		} 
		else if (button.equalsIgnoreCase("BookTnxList")) {
			System.out.println("All book  transaction details ");
			List<BookTnxDto> bookTnxList = LibraryInfoDao.viewBookTnx();
			session.setAttribute("bookTnxList", bookTnxList);
			rd = request.getRequestDispatcher("BookTnxView.jsp");
		} else {
			System.out.println("buttonaction required");
		}
		rd.forward(request, response);
		System.out.println("AdminPage doGet ends");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
