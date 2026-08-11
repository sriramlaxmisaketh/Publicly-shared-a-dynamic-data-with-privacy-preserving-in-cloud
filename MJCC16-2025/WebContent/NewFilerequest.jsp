<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.model.UserFiles"%>
<%@page import="java.util.List"%>
<%@page import="com.database.DatabaseImplementation"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('pexels-dominika-roseclay-1036841.jpg'); background-repeat: no-repeat;background-attachment: fixed;
  background-size: cover;">
</nav>
		<br>
		
			<br> <center>
			<h1 style="background-color:DodgerBlue; style="padding: 30px;">
PUBLICLY SHARED A DYNAMIC DATA WITH PRIVACY PRESERVING IN CLOUD
</h1>
		</center>
		<br>
	<%
int userid=(Integer)session.getAttribute("userid");
DatabaseImplementation di=new DatabaseImplementation();
List<UserFiles> files=di.userReq(userid);
%>
<center>
<h2>Audit Proof Files</h2>
	<table style="width:35%">
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
				<td><a href="Allfilesdownload?fileName=<%=uf.getFileName()%>"><%=uf.getStatus() %></a></td>
			</tr>
			<% }%>

		</table>
	</div>
</body>
</html>