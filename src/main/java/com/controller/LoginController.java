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
import com.dto.Address;
import com.dto.MmbrRegDto;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login controller  doGet Starts");
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String button = request.getParameter("buttonaction");
		System.out.println("Action : " + button);
		RequestDispatcher rd = null;
		if (button.equalsIgnoreCase("Signup")) {
			rd = request.getRequestDispatcher("MemberReg.jsp");
		} else if (button.equalsIgnoreCase("Login")) {

			//public MmbrRegDto reg() {
			String memberId = request.getParameter("memberId");
			int mmbrId=Integer.parseInt(memberId);
			String memberType = request.getParameter("type");

			MmbrRegDto mmbrRegDto = new MmbrRegDto();
			mmbrRegDto.setMemberID(mmbrId);
			mmbrRegDto.setMemberType(memberType);
			//}
			session.getAttribute("mmbrRegDto");
			mmbrRegDto= LibraryInfoDao.loginMember(mmbrRegDto);
			if(mmbrRegDto!=null && mmbrRegDto.getMemberType().equalsIgnoreCase("Admin")) {
				out.println("<h1 style='color:green;margin-top:100px;'>Hi"+mmbrRegDto.getMemberName()+" , you are Login successfully</h1>");
				session.setAttribute("mmbrRegDto", mmbrRegDto);
				rd = request.getRequestDispatcher("Admin.jsp");
				rd.forward(request, response);
			} else {
				out.println("<h1 style='color:red;margin-top:100px;'>Invalid member</h1>");
				rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
				System.out.println("Error in Login");
			}
		}//rd.forward(request, response);
		System.out.println("LoginController doGet ends");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
