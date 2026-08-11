<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.database.DatabaseImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="sytlesheet" href="./css/mystyle.css">
<title>Insert title here</title>
<style>
h1 {
	text-align: center;
}
</style>
</head>
<body
	style="background-image: url('pexels-simon-berger-1323550.jpg'); background-repeat: no-repeat;background-attachment: fixed;
  background-size: cover;">

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-info"> <a
			class="navbar-brand" href="#"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				

			</div>
		</div>
		</nav>
		<h3 style="padding: 30px;">
PUBLICLY SHARED A DYNAMIC DATA WITH PRIVACY PRESERVING IN CLOUD
</h3>
	</div>

	<h1 style>REGISTER</h1>
	<div class="container">
		<div class="row" style="border-style: solid;">
			<div class="col-3"></div>
			<div class="col-3">

				<form action="register" method="post">
					<label class="myfont" style="margin-bottom: 10px;">Enter
						Name</label><br /> <input type="text" name="name1" /><br /> <label
						class="myfont" style="margin-bottom: 10px;">Enter DOB </label><br />
					<input type="date" name="date" /><br /> <label class="myfont"
						style="margin-bottom: 10px;">Enter Email</label><br /> <input
						type="email" name="email" /><br /> <label class="myfont"
						style="margin-bottom: 10px;">Enter Password</label><br /> <input
						type="password" name="password" /><br /> <label>Select
						Gender</label><br /> <input type="radio" name="gender" value="male">
					Male<br> <input type="radio" name="gender" value="female">
					Female<br>
			</div>
			<div class="col-sm">
				<h1></h1>
				<label class="myfont" style="margin-bottom: 10px;">Enter
					Phone Number</label><br /> <input type="text" name="pnumber" /><br /> <label
					class="myfont" style="margin-bottom: 10px;">Enter Adress</label><br />
				<input type="text" name="adress" /><br /> <label for="cars">Choose Groups :</label> <select name="group">
					<%
DatabaseImplementation di=new DatabaseImplementation();
List<String> al=di.groups();
for(String s: al){%>
					<option value=<%=s %>><%=s %></option>
					<%}
%>
				</select> <input type="submit" " value="Register" style="margin-top: 10px;"
					class="btn btn-success" /><br />

				</form>
			</div>
		</div>
	</div>






</body>
</html>