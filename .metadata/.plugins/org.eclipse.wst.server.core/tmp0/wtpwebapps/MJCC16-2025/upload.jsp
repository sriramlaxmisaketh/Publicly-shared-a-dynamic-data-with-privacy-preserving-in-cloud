<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./common/usernavigation.jsp" />
	<div class="container">
	<center>
		<%
/* session.setAttribute("userid",um.getUserid()); 
session.setAttribute("userid",um.getName());  */
int userid=(Integer)session.getAttribute("userid");
%>
<br><br><br><br><br>
		welcome
		<%=(String)session.getAttribute("userName") %>
		<% String message=(String)request.getAttribute("message");

if(message==null){%>


		<% }else{%>

		<p style="color: red;"><%=message %></p>
		<%} %>
		<form action="uploadfile" method="post" enctype="multipart/form-data">
		<br>

			<label>File Name</label> <input type="text" name="fileName" />&nbsp;&nbsp;
			<input type="file" name="file">&nbsp;&nbsp; <input type="hidden"
				value="<%=userid%>" name="userid" /> &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit"
				value="submit" />
		</form>
	</div>

</body>
</html>