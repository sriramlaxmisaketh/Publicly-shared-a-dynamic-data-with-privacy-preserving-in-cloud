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
List<UserFiles> files=di.userFiles1(userid);
%>

	<div style="background-color:yellow; class="container">
		<table class="table">
		<br><br><br><br><br><br>
			<tr>
				<td>User Id</td>
				<td>File Name</td>
				<td>Download</td>
			</tr>
			<%
for(UserFiles uf: files){%>
			<tr>
				<td><%=uf.getUserid() %></td>
				<td><%=uf.getFileName() %></td>
				<td><a
					href="request.jsp?fileName=<%=uf.getFileName()%>&&userid=<%=userid%>">Request</a></td>
			</tr>
			<% }%>

		</table>
	</div>
</body>
</html>