package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DatabaseImplementation;
import com.interfaces.DatabaseInterface;
import com.interfaces.GroupInterface;

/**
 * Servlet implementation class GroupCreation
 */
@WebServlet("/groupcreation")
public class GroupCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupCreation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String groupname=request.getParameter("group");
		String groupsize=request.getParameter("size");
	System.out.println(groupname+groupsize);
		GroupInterface di=new DatabaseImplementation();
		boolean f= di.insertGroup(groupname, groupsize);
		if(f){
			request.setAttribute("message", "Group created successfully");
			
			request.getRequestDispatcher("creategroup.jsp").include(request, response);
			System.out.println("inserted");
		}else{
request.setAttribute("message", "Creation of Group Failed/ Group name is same");
			
			request.getRequestDispatcher("creategroup.jsp").include(request, response);
			System.out.println("not inserted");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
