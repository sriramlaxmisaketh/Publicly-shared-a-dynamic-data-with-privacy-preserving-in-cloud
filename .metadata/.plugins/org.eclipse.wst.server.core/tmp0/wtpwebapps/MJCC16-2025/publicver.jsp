<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		</div>
		</div>
		</nav>
		<center>
		<h1 style="background-color:DodgerBlue;">
PUBLICLY SHARED A DYNAMIC DATA WITH PRIVACY PRESERVING IN CLOUD
</h1>
	</div>
	<center>
		<div class="container">
		<center>
		<br>
			<% String message=(String)request.getAttribute("message");

if(message==null){%>


			<% }else{%>

			<p style="color: red;"><%=message %></p>
			<%} %>

			<div class="row">
				<div class="col-sm"></div>
				<div class="col-sm" style="border-style: solid;">
					<h3>AUDITOR LOGIN</h3>
					<br>
					<br>
					</body></body>

					<form action="PublicLogin" method="post">
						<label class="myfont" style="margin-bottom: 10px;">Enter
							User Name</label><br /> <input type="text" name="username" /><br />
						<br> <label style="margin-bottom: 10px;">Enter
							Password</label><br /> <input type="password"
							style="margin-bottom: 10px;" name="password" /><br /> <input
							type="submit" " value="Login" style="margin-top: 10px;"
							class="btn btn-success" /><br />
						<div style="margin-top: 15px;">
					</form>

				</div>
			</div>
			<div class="col-sm"></div>
		</div>
</body>
</html>