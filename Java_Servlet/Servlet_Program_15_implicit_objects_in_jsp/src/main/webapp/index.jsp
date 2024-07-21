<html>
<body>
<%
out.println("I am index.jsp file out.println() text, For print not need to create PrintWrite object");

session.setAttribute("index.jsp_file_session", "i am 'index.jsp_file_session', for using session in jsp file not need to create HttpSession object");
%>
<br><br>
<a href="javaFile">Click me </a>to Run MyServlet.java file
<br><br>
<form action="output.jsp" method="get">
    <input type="text" name="nameInput" placeholder="Enter Your Name" />
    <input type="submit" value="Submit" /> to see output
</form>
<h3 style="margin: 0px;">What is implicit objects in JSP ? </h3>
=> <p style="display: inline;">JSP implicit objects are pre-defined variable tha area available for use without any explicit declaration or initialization. These Object are automatically crated by the JSP container and provide access to various functionalities and information related to the JSP page, request, session, application, and more...<p>
<h3 style="margin: 0px;">Implicit object in JSP / Predefined object in JSP :-</h3>
<img src="img.png" style="border: 2px solid black; width: 100%;" />
</body>
</html>
