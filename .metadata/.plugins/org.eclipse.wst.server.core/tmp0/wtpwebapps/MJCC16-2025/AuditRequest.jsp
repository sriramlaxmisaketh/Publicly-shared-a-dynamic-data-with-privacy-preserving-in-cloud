<%@page import="com.model.UserFiles"%>
<%@page import="java.util.List"%>
<%@page import="com.database.DatabaseImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./common/punav.jsp" />
	<div style="background-color:RED; class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
	
	</div>
	<%
//int userid=(Integer)session.getAttribute("userid");
DatabaseImplementation di=new DatabaseImplementation();
List<UserFiles> files=di.publicReq();
%>
	<div class="container">
		<% String message=(String)request.getAttribute("message");

if(message==null){%>


		<% }else{%>

		<p style="color: red;"><%=message %></p>
		<%} %>

		<table class="table">
			<tr>
				<td>USER ID</td>
				<td>FILE NAME</td>
				<td>STATUS</td>
			</tr>
			<%
for(UserFiles uf: files){%>
			<tr>
				<td><%=uf.getUserid() %></td>
				<td><%=uf.getFileName() %></td>
				<td><a href="Approve?userid=<%=uf.getUserid()%>"><%=uf.getStatus() %></a></td>
			</tr>
			<% }%>

		</table>
	</div>
</body>
</html>