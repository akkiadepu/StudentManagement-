package com.codegana.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.codegana.beans.Student;
import com.codegana.service.StudentService;
import com.codegnan.exception.DatabaseInternalException;

/**
 * Servlet implementation class StudentRegsitration
 */
public class StudentRegsitration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegsitration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Logger logger =Logger.getLogger(StudentRegsitration.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		if(session != null && session.getAttribute("username")!= null) {
			int id =Integer.parseInt(request.getParameter("id"));
			String name =request.getParameter("name");
			String email=request.getParameter("email");
			Student student=new Student(id, name, email);
			
			StudentService studentService=new StudentService();
	
			try {
				logger.debug("saving student "+student);
				studentService.saveStudent(student);
				logger.debug("saved successfully");
			} catch (ClassNotFoundException e) {
				logger.error(e);
			} catch (DatabaseInternalException e) {
				logger.error(e);
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("student.jsp");
		
	}
	
}
	
