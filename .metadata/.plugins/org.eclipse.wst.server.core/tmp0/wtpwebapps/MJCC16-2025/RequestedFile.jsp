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
	<jsp:include page="./common/usernavigation.jsp" />
	<%
int userid=(Integer)session.getAttribute("userid");
DatabaseImplementation di=new DatabaseImplementation();
List<UserFiles> files=di.userReq(userid);
%>
	<div style="background-color:yellow; class="container">
		<table class="table">
			<tr>
			<br><br><br><br>
				<td>User Id</td>&nbsp;&nbsp;&nbsp;
				<td>File Name</td>&nbsp;&nbsp;&nbsp;
				<td>STATUS</td>&nbsp;&nbsp;&nbsp;
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