/*package com.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import database.connection;
import database.RandomeString;
import database.Test;

*//**
 * Servlet implementation class Upload
 *//*
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part filepart=request.getPart("file");
    	String fname=request.getParameter("fname");
    	String fdes=request.getParameter("fdes");
    	HttpSession ses=request.getSession(false);
    	String gid=(String)ses.getAttribute("uid");
    	Part filepart1=request.getPart("file");
    	HttpSession hs=request.getSession();
    	String emailid=(String) hs.getAttribute("mail");
    	//String gname=Da .getGroupName(gid);
		InputStream inputStream, input;
		FileOutputStream filePart;
		String file=filepart1.getName();
		int fileSize = (int) filepart1.getSize();
		System.out.println(fileSize);
		int PART_SIZE = (int)fileSize/3;
		int nChunks = 0, read = 0, readLength = PART_SIZE;
		String num=RandomeString.getFid();
		byte[] byteChunkPart, byteChunkPart1;
		String key=RandomeString.getSaltString();
		try {
		connection con=database.Connection();
		Connection conn=connection.getConnection();
		Statement st=conn.createStatement();
		input = filepart.getInputStream();
		String type=filepart.getContentType();
		int i=st.executeUpdate("insert into data value('"+num+"','"+emailid+"','"+fname+"',0,0,0,0,'"+type+"','"+fdes+"','"+key+"','"+key+"','"+key+"','"+key+"','pending')");
		String sql ="insert into data1(fid,uid, fname, Part, type, fdes, f1key, f2key, f3key, f4key) value(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, num);
		ps.setString(2, emailid);
		ps.setString(3, fname);
		ps.setBinaryStream(4, input);
		ps.setString(5, type);
		ps.setString(6, fdes);
		ps.setString(7, key);
		ps.setString(8, key);
		ps.setString(9, key);
		ps.setString(10, key);
		i = ps.executeUpdate();
		System.out.println(i+" "+file);
			inputStream = filepart1.getInputStream();
			int ji=0;
			while (fileSize > 0) {
				ji++;
				if (fileSize <= 5) {
					readLength = fileSize;
				}
				byteChunkPart = new byte[readLength];
				read = inputStream.read(byteChunkPart, 0, readLength);
				fileSize -= read;
				String text = new String(byteChunkPart);
				String key1 = RandomeString.getSaltString();
				String enc = Test.encryption(text, key1);
				byteChunkPart1 = enc.getBytes();
				String tx = new String(byteChunkPart1);
				System.out.println(tx);
				PreparedStatement ps2=conn.prepareStatement("update data set part"+ji+"=?, f"+ji+"key=? where fid=?");	
				PreparedStatement ps1=conn.prepareStatement("update data1 set f"+ji+"key=? where fid=?");
				assert (read == byteChunkPart.length);
				nChunks++;
				File nf=new File("temp.txt");
				filePart = new FileOutputStream(nf);
				filePart.write(byteChunkPart1);
				ps2.setBinaryStream(1, new FileInputStream(nf), fileSize);
				ps2.setString(2, key1);
				ps2.setString(3, num);
				ps1.setString(1, key1);
				ps1.setString(2, num);
				int i2=ps2.executeUpdate();
				i2 = ps1.executeUpdate();
				filePart.flush();
				filePart.close();
				byteChunkPart = null;
				filePart = null;
				byteChunkPart1 = null;
				System.out.println(nChunks+" "+i2);
			}
			inputStream.close();
			response.sendRedirect("Upload.jsp?Uploaded_Successfully");
			System.out.println("compleated");
		} catch (IOException | SQLException exception) {
			exception.printStackTrace();
		}
	}

}
*/