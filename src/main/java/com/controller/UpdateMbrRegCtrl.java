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
import com.dto.BookRegDto;
import com.dto.MmbrRegDto;


@WebServlet("/UpdateMbrReg")
public class UpdateMbrRegCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Update Member Registration  doGet Starts");
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String button = request.getParameter("buttonaction");
		System.out.println("Action : " + button);
		RequestDispatcher rd = null;
		if (button.equalsIgnoreCase("Back")) {
			rd = request.getRequestDispatcher("index.jsp");
		} else if (button.equalsIgnoreCase("UpdateMember")) {

			//public MmbrRegDto reg() {
			String memberId = request.getParameter("memberId");
			int mmbrId=Integer.parseInt(memberId);
			String memberName = request.getParameter("memberName");
			String StreetNo = request.getParameter("StreetNo");
			String StreetName = request.getParameter("StreetName");
			String City = request.getParameter("City");
			String District = request.getParameter("District");
			String Pincode = request.getParameter("Pincode");
			long pincode = Long.parseLong(Pincode);
			String memberType = request.getParameter("type");
			Address address = new Address(StreetNo, StreetName, City, District, pincode);

			MmbrRegDto mmbrRegDto = new MmbrRegDto(mmbrId, memberName, address, memberType);
			session.setAttribute("mmbrRegDto", mmbrRegDto);
			//}
			session.getAttribute("mmbrRegDto");
			boolean status = LibraryInfoDao.updateMember(mmbrRegDto);
			if(status) {
				out.println("<h1 style='color:green;margin-top:100px;'>Hi  "+memberName+" , you are updated successfully</h1>");
				out.println("<h1 style='color:black;margin-top:120px;'><a href='index.jsp'>Home</a></h1>");
				rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
				
			} else {
				out.println("<h1 style='color:red;margin-top:100px;'>Error in Registration</h1>");
				rd = request.getRequestDispatcher("MemberReg.jsp");
				rd.include(request, response);
				System.out.println("Error in Registration");
			}
		}//rd.forward(request, response);
		System.out.println("Member Registration doGet ends");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
