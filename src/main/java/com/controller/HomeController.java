package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomePage doGet Starts");
		String button = request.getParameter("buttonaction");
		System.out.println("Action : "+button);
		RequestDispatcher rd = null;
		if(button.equalsIgnoreCase("AddMember")) {
			rd=request.getRequestDispatcher("MemberReg.jsp");
		}else if(button.equalsIgnoreCase("AddBook")) {
			rd=request.getRequestDispatcher("BookReg.jsp");
		}else if(button.equalsIgnoreCase("Login")) {
			rd=request.getRequestDispatcher("Login.jsp");
		}else if(button.equalsIgnoreCase("BookTnx")) {
			rd=request.getRequestDispatcher("BookTransaction.jsp");
		}else {
			System.out.println("buttonaction required");
		}
		rd.forward(request, response);
		System.out.println("HomePage doGet ends");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
