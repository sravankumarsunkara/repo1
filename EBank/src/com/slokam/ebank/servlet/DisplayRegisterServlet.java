package com.slokam.ebank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slokam.ebank.pojo.UserPojo;

/**
 * Servlet implementation class DisplayRegisterServlet
 */
public class DisplayRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserPojo userPojo=new UserPojo();
		userPojo.setUserName("");
		userPojo.setPassword("");
		userPojo.setStatus("");
		userPojo.setBalance(0.0f);
		//userPojo.setId(0);
		request.setAttribute("userData", userPojo);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

}
