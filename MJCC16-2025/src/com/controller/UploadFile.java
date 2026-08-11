package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.database.DatabaseImplementation;
import com.database.Encode;
import com.controller.GFG2;

@WebServlet("/uploadfile")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class UploadFile extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Part filepart1=req.getPart("file");
		HttpSession ses=req.getSession(false);
    	String uid=(String)ses.getAttribute("uid");
    	InputStream inputStream, input;
		FileOutputStream filePart;
		
		String userid=req.getParameter("userid");
		String fileName1=req.getParameter("fileName");
		String hashValue=GFG2.getHash("fileName");
		try {
			Cipher cipher = Cipher.getInstance("AES");
			System.out.println(cipher);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(filepart1==null){
			System.out.println("filepart is null");
		}else{
			System.out.println("file part is not null");
		}
	//
		String file=filepart1.getName();
		/*String filePath= "D:\\workspace\\Major project 2022\\VTJCC07\\WebContent\\";*/
		String filePath= "D:\\Miniproject\\MJCC16-2025\\WebContent\\";
		System.out.println("file"+filePath);
		
		inputStream= filepart1.getInputStream();
		FileOutputStream outputStream = new FileOutputStream(filePath+"\\files\\" + fileName1+".txt"); 
		  int i=0;    
          while((i=inputStream.read())!=-1){    
        	  outputStream.write(i);      
          }    
          inputStream.close(); 
		
          
        DatabaseImplementation di=new DatabaseImplementation();
        String s=di.uploadFile(Integer.parseInt(userid), fileName1);
        if(s.equalsIgnoreCase("success")){
        	req.setAttribute("message", "File uploaded successfully");
		req.getRequestDispatcher("upload.jsp").include(req, resp);
        
         // resp.getWriter().print("The file uploaded sucessfully.");
        }
        else{
        	req.setAttribute("message", "Failed to  Upload the File?");
    		req.getRequestDispatcher("upload.jsp").include(req, resp);
        	resp.getWriter().print("The file upload failed");
        }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
