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
<body style="background-image: url('pexels-simon-berger-1323550.jpg'); background-repeat: no-repeat;background-attachment: fixed;
  background-size: cover;">">
	<div class="container">
		<nav class="navbar navbar-expand-lg"> <a class="navbar-brand"
			href="#"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active" href="#">Home <span
					class="sr-only"></span></a> <a class="nav-item nav-link" href="groupmember.html">Group
					Member</a> <a class="nav-item nav-link" href="groupmanager.html">Group
					Manger</a> <a class="nav-item nav-link" href="publicver.jsp">Third party Auditor </a> <a
					class="nav-item nav-link" href="#">Cloud Storage Server</a> <a
					class="nav-item nav-link" href="#">Logout</a>

			</div>
		</div>
		</nav>
		<br>
		<h3>
			<br> 
PUBLICLY SHARED A DYNAMIC DATA WITH PRIVACY PRESERVING IN CLOUD

		</h3>
	</div>
	<div style="margin-top: 100px:">
		<div class="container">
			<div class="row">
				<div class="col-sm"></div>
				<div class="col-sm" style="border-style: solid;">
					<h1>LOGIN</h1>
					<% String message=(String)request.getAttribute("message");

if(message==null){%>


					<% }else{%>

					<p style="color: red;"><%=message %></p>
					<%} %>
					<form action="Login" method="post">
						<label class="myfont" style="margin-bottom: 10px;">Enter
							User Name</label><br /> <input type="text" name="username" /><br />
						<br> <label style="margin-bottom: 10px;">Enter
							Password</label><br /> <input type="password"
							style="margin-bottom: 10px;" name="password" /><br /> <input
							type="submit" value="Login" style="margin-top: 10px;"
							class="btn btn-success" /><br />
						<div style="margin-top: 15px;">
							<!-- <a href="register.html">Register</a> -->
					</form>

				</div>
			</div>
			<div class="col-sm"></div>
		</div>
	</div>
	</div>
	<div></div>
</body>
</html>