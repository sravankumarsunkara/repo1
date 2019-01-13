package com.slokam.ebank.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.slokam.ebank.exception.EBankException;
import com.slokam.ebank.pojo.UserPojo;
import com.slokam.ebank.service.AdminService;
import com.slokam.ebank.service.UserService;

public class UserSearch extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String userName=request.getParameter("userName");
		ApplicationContext context= new ClassPathXmlApplicationContext("annotation_context.xml");
		AdminService adminService=(AdminService)context.getBean("adminService");
		
		try {
			
			Collection<UserPojo> collection=adminService.similarUser(userName);
			request.setAttribute("users", collection);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} catch (EBankException e) {
		  e.printStackTrace();
		}
	}

}
