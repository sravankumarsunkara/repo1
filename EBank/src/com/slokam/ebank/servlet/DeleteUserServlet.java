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

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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
		String idStr=request.getParameter("id");
		ApplicationContext context=new ClassPathXmlApplicationContext("annotation_context.xml");
		LoginService loginService=(LoginService)context.getBean("loginService");
		UserPojo userPojo=null;
		if(Integer.parseInt(idStr)>0)
		try {
			userPojo=new UserPojo();
			userPojo.setId(Integer.parseInt(idStr));
			loginService.deleteUser(userPojo);
			AdminService adminService=(AdminService)context.getBean("adminService");
	    	Collection<UserPojo> collection= adminService.getUsers();
	    	request.setAttribute("users", collection);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} catch (EBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
