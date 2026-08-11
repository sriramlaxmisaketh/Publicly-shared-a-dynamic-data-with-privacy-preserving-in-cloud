<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="sytlesheet" href="./css/mystyle.css">
<title>Insert title here</title>
</head>
<body>
  <center>     
<div class="collapse navbar-collapse">
<nav>


                     

	<jsp:include page="./common/usernavigation.jsp" />
	<div style="margin-top: 100px:">
		<div class="container">
			<div class="row">
			
				<%
     String name= (String)session.getAttribute("userName");
     %>
				<h3 style="color: red; text-align: center;">
				<br><br><br>
					Welcome
					<%=name %></h3>
				<div class="col-sm"></div>
				<div class="col-sm"></div>
			</div>
			<div class="col-sm"></div>
		</div>
	</div>
	</div>
	<div></div>
</body>
</html>