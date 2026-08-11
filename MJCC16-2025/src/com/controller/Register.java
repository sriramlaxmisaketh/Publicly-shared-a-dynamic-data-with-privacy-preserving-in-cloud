package com.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.xml.ws.Response;
*/
import com.database.DatabaseImplementation;
import com.database.DbConnection;
import com.interfaces.DatabaseInterface;
import com.model.UserModel;


@WebServlet("/register")
public class Register extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name1");
		String date=req.getParameter("date");
		String email=req.getParameter("email");
		
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String pnumber=req.getParameter("pnumber");
		String address=req.getParameter("adress");
		String group=req.getParameter("group");
		
		System.out.println(name+"\n"+date+"\n"+email+"\n"+password+"\n"+gender+"\n"+pnumber+"\n"+address+"\n"+group);
		
		UserModel um=new UserModel();
		um.setName(name);
		um.setDob(date);
		um.setEmail(email);
		um.setPassword(password);
		um.setGroup(group);
		um.setAddress(address);
		um.setPnumber(pnumber);
		um.setGender(gender);
		um.setStatus("pending");
		
		try {
			
		
			Connection con=DbConnection.getConnection();
			if(con==null){
				
			System.out.println("connection not found");	
			}else{
				DatabaseInterface db=new DatabaseImplementation();
				int i=db.registerUser(um);
				if(i==0){
					System.out.println("not inserted");
					
				}else{
					System.out.println("inserted");
					 out = resp.getWriter();  
					resp.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Register Success');");  
					out.println("</script>"); 
			            resp.sendRedirect("groupmanager.html");
				}
				
				
			}
			// TODO Auto-generated catch block
				
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		out.close();

}
}