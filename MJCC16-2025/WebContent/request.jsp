<%@page import="com.database.DatabaseImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="./common/usernavigation.jsp" />

<%
String filename=request.getParameter("fileName");
String userid=request.getParameter("userid");
//System.out.println(filename+userid);
DatabaseImplementation di=new DatabaseImplementation();
boolean f=di.requestFile(Integer.parseInt(userid), filename, "pending");
if(f){%>
<a href="allFiles.jsp">Back</a>
<br><br><br><br><br><br>
<%out.println("Request Sent successfully");
}else{
out.println("not processed");
}
%>
</body>
</html>