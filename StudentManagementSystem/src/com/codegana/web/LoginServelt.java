package com.codegana.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.codegana.service.UserService;
import com.codegnan.exception.DatabaseInternalException;

/**
 * Servlet implementation class LoginServelt
 */
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Logger logger = Logger.getLogger(LoginServelt.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("Login form subimtted");
		String username =request.getParameter("username");
		String password=request.getParameter("password");
		try {
			if(validate(username, password)) {
				HttpSession session=request.getSession(true);
				session.setAttribute("username", username);
				RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
				rd.forward(request, response);
				
			}
			else {
				response.sendRedirect("index.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (DatabaseInternalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		
		
	}
	public boolean validate(String username,String password) throws ClassNotFoundException, SQLException, DatabaseInternalException {
		UserService userServices =new UserService();
		return userServices.validate(username, password);
	}

}
