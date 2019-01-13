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
 * Servlet implementation class DisplayUserDetails
 */
public class DisplayUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		ApplicationContext context=new ClassPathXmlApplicationContext("annotation_context.xml");
		UserService userService=(UserService)context.getBean("userService");
		try {
			UserPojo userPojo=userService.getUserInfo(id);
			request.setAttribute("userDetails", userPojo);
			request.getRequestDispatcher("user.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			
		}
	
	}

}
