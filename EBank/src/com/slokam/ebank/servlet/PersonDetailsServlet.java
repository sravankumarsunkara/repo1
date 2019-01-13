package com.slokam.ebank.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.slokam.ebank.pojo.PersonSearchPojo;
import com.slokam.ebank.service.PersonService;

/**
 * Servlet implementation class PersonDetailsServlet
 */
public class PersonDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonDetailsServlet() {
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
		String personName=request.getParameter("personName");
		String passportNo=request.getParameter("passportNo");
		String phoneNum=request.getParameter("phoneNum");
		String courseName=request.getParameter("courseName");
		PersonSearchPojo pojo=new PersonSearchPojo();
		pojo.setPersonName(personName);
		pojo.setPassportNo(passportNo);
		pojo.setPhoneNo(phoneNum);
		pojo.setCourses(courseName);
		ApplicationContext context=new ClassPathXmlApplicationContext("annotation_context.xml");
		PersonService personService=(PersonService)context.getBean("personService");
		List<Object[]> person=personService.searchPerson(pojo);
		request.setAttribute("personDetails",person );
		request.getRequestDispatcher("person_management.jsp").forward(request, response);
	}

}
