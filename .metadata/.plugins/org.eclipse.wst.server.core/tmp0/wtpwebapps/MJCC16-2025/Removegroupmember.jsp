<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.database.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%
/*  String value = request.getParameter("groupname"); */
String value=request.getParameter("groupname");
 
 Connection conn = null;
 try{
	 String sql="DELETE FROM grouptable WHERE groupname=?";
 PreparedStatement pst = conn.prepareStatement(sql);
 int i=pst.executeUpdate();
 if(i==-1){
	 System.out.println("failed to del");
 }else{
	 System.out.println("deleted");
 }

}catch(Exception e){
e.printStackTrace();
}

%>