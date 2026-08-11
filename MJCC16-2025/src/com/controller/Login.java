package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.DatabaseImplementation;
import com.interfaces.DatabaseInterface;
import com.model.UserModel;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		DatabaseInterface di=new DatabaseImplementation();
		UserModel um= di.loginUser(username, password);
		
		if (um==null){
			System.out.println("user not found ");
			request.setAttribute("message", "User Details not Found  / GroupManager did not approve the status");
			request.getRequestDispatcher("Login.jsp").include(request, response);
		}else{
			System.out.println("user found wiht name"+um.getName());
			HttpSession session=request.getSession();  
	        session.setAttribute("userid",um.getUserid()); 
	        session.setAttribute("userName",um.getName()); 
	        response.sendRedirect("usersuccess.jsp");
		}
		
		
		
		
	}

}
