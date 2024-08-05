<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp">Back to Index Page</a><br><br>
	<form action="formSubmit" method="post">
		Name: <input type="text" name="name" /><br><br>
		Email: <input type="email" name="email" /><br><br>
		Phone Number:- <input type="number" name="number" /><br><br>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>