package com.slokam.ebank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.slokam.ebank.exception.EBankException;
import com.slokam.ebank.pojo.UserPojo;
import com.slokam.ebank.service.UserService;

/**
 * Servlet implementation class UpdateUserDetailsServlet
 */
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsServlet() {
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
	    Integer id=Integer.parseInt(request.getParameter("id"));
	    /*String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String status=request.getParameter("status");
		String balance=request.getParameter("balance");*/
	    ApplicationContext context= new ClassPathXmlApplicationContext("annotation_context.xml");
		UserService userService=(UserService)context.getBean("userService");
		String nextPage="login.jsp"; 
		UserPojo userPojo=null;
		try {
			userPojo=userService.getUserDetails(id);
			
			request.setAttribute("userData", userPojo);
			nextPage="register.jsp";
			
		} catch (EBankException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}

}
