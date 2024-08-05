<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %> <!-- use Expresetion than do this  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello Welcome Vishal</h3>
	<!-- 
	<h4>Name: ${model_name}</h4>
	<h4>Email: ${model_email}</h4>
	<h4>Number: ${model_number}</h4>
	-->
	 
	<!-- 
	<h4>Name: ${model_user.getName()}</h4>
	<h4>Email: ${model_user.getEmail}</h4>
	<h4>Number: ${model_user.getNumber}</h4>
	-->
	
	<h4>Name: ${user.getName()}</h4>
	<h4>Email: ${user.getEmail()}</h4>
	<h4>Number: ${user.getNumber()}</h4>
</body>
</html>