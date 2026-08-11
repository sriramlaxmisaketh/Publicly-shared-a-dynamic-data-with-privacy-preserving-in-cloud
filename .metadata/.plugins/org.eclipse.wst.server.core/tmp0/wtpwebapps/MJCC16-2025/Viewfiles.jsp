<%@page import="com.model.UserFiles"%>
<%@page import="java.util.List"%>
<%@page import="com.database.DatabaseImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
	<jsp:include page="./common/navigation.jsp" />
	<div style="background-color:RED; class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
	
	<br><br>
	<center>
	<h1>Files</h1>
	
	<%
int userid=(Integer)session.getAttribute("userid");
DatabaseImplementation di=new DatabaseImplementation();
List<UserFiles> files=di.userFiles(userid);
%>
	<div class="container">
		<table class="table">
			<tr>
			     


				<td>USER ID</td><br>
				<td>FILE NAME</td><br>
				<td>DOWNLOAD</td><br>
			</tr>
			<%
for(UserFiles uf: files){%>
			<tr>
				<td><%=uf.getUserid() %></td>
				<td><%=uf.getFileName() %></td>
				<td><a href="download?fileName=<%=uf.getFileName()%>">Download</a></td>
			</tr>
			<% }%>

		</table>
		</center>
	</div>
</body>
</html>