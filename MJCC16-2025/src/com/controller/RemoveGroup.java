package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DbConnection;

/**
 * Servlet implementation class RemoveGroup
 */
@WebServlet("/RemoveGroup")
public class RemoveGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("groupname");
		 
		 Connection conn;
		
	
		 try{
			 conn = DbConnection.getConnection();
			 String sql="DELETE FROM grouptable WHERE groupname=?";
		 PreparedStatement pst = conn.prepareStatement(sql);
		 pst.setString(1, value);
		 int i=pst.executeUpdate();
		 if(i==-1){
			/*String message = "Group has deleted successfully.";*/
			 System.out.println("failed to del");
			
			 // Store the message in a request attribute
			   /* request.setAttribute("message", message);*/
		 }else{
			 System.out.println("deleted");
			 String message = "Group has deleted successfully.";
			 // Store the message in a request attribute
			    request.setAttribute("message", message);
			 // Forward the request to the JSP page
			    RequestDispatcher dispatcher = request.getRequestDispatcher("LeaveUser.jsp");
			    dispatcher.forward(request, response);
		 }

		}catch(Exception e){
		e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
