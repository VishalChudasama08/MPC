<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Servlet_Program_10_HttpSession_session_management</title>
</head>

<body>
	<%
	    String myName = request.getParameter("nameInput");
	    out.println("Welcome " + myName);
	%>
	<br>
	<%
	    String indexFileSessionValue = (String) session.getAttribute("index.jsp_file_session"); // this return object than type caste to string
	    out.println("Index.jsp file session value is '" + indexFileSessionValue + "'");
	%>
	<br>
	<%
	    String mySessionFileSessionValue = (String) session.getAttribute("session_name"); // this return object than type caste to string
	    out.println("MyServlet.java file session value is '" + mySessionFileSessionValue + "'");
	%>
	<br><a href='index.jsp'>Go Index.jsp page</a>
	<br><a href="javaFile">Click me </a>to Run MyServlet.java file
</body>

</html>