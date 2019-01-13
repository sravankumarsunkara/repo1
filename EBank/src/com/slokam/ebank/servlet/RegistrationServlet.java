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

/**
 * Servlet implementation class GetRegistrationDetailsServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String status=request.getParameter("status");
		String balance=request.getParameter("balance");
		String nextPage="login.jsp";
		String sid=request.getParameter("userid");
		System.out.println(sid);
		 Integer id=null;
		 if(sid!=null&&! sid.trim().equals("")&&!sid.trim().equals("null")){
		id=	 Integer.parseInt(sid);
		 }
		UserPojo userPojo= null;
		ApplicationContext context= new ClassPathXmlApplicationContext("annotation_context.xml");
		
		LoginService loginService=(LoginService)context.getBean("loginService");
				
				userPojo=new UserPojo();
				userPojo.setUserName(userName);
				userPojo.setPassword(password);
				userPojo.setStatus(status);
				userPojo.setId(id);
				userPojo.setRole("user");
				userPojo.setBalance(Float.parseFloat(balance));
				try
				{
					if(id==null){
				loginService.regisUser(userPojo);
				AdminService adminService=(AdminService)context.getBean("adminService");
		    	Collection<UserPojo> collection= adminService.getUsers();
		    	request.setAttribute("users", collection);
				nextPage="admin.jsp";
					}
					else
					{
						loginService.updateUser(userPojo);
						UserService userService = (UserService)context.getBean("userService");
				    	UserPojo pojo=userService.getUserInfo(userPojo.getId());
						request.setAttribute("userDetails", pojo);
						nextPage="user.jsp";
						
					}
		} 
				catch (EBankException e)
		{
					e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			
		}
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
		
}
