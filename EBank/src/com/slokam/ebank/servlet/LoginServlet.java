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
import com.slokam.ebank.service.LoginService;
import com.slokam.ebank.service.UserService;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
	    String name=request.getParameter("username");
	    String pass=request.getParameter("password");
	    System.out.println(name);
	    System.out.println(pass);
	    String nextPage="login.jsp";
	    
	    UserPojo result=null;
	    
	    try
	    {
	    	ApplicationContext context= new ClassPathXmlApplicationContext("annotation_context.xml");
	    	LoginService loginService=(LoginService)context.getBean("loginService");
	    	result=loginService.verifyUser(name, pass);
	        request.getSession().setAttribute("users",result );
	        if(result.getRole()==null)
	        {
	    	
	    	 request.setAttribute("error","UserName and Password are not existed");
	        }
	        else if(result.getRole().equals("admin"))
	        {
	    	  AdminService adminService=(AdminService)context.getBean("adminService");
	    	  Collection<UserPojo> collection= adminService.getUsers();
	    	  request.setAttribute("users", collection);
	    	  nextPage="admin.jsp";
	        }
	    else if(result.getRole().equals("user"))
	    {
	    	UserService userService = (UserService)context.getBean("userService");
	    	UserPojo userPojo=userService.getUserInfo(result.getId());
			request.setAttribute("userDetails", userPojo);
			nextPage="user.jsp";
	    }
	   }
	   catch(EBankException e)
	   {
	    	request.setAttribute("error", e.getMessage());
	   }
	    request.getRequestDispatcher(nextPage).forward(request, response);
	 }

}

