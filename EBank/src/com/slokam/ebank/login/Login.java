package com.slokam.ebank.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
	    PrintWriter pw=response.getWriter();
	    String name=request.getParameter("username");
	    String pass=request.getParameter("password");
	    System.out.println(name);
	    System.out.println(pass);
	    if(name.equals(pass))
	    {
	    	request.getRequestDispatcher("welcome.html").forward(request,response);
	    }
	    else
	    {
	    	request.setAttribute("msg","User name and password are not same");
	    	request.getRequestDispatcher("login.jsp").forward(request,response);
	    }
	}

}
