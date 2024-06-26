<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Servlet_Program_09_RequestDispatcher_interface_open_new_file_withot_chenge_url Maven Webapp. servises.jsp page
    </title>
</head>

<body>
    <%
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
    %>
    <h3>Services</h3>
    <p>Name: <%= name %></p>
    <p>Email: <%= email %></p>
    <a href="aboutUs.jsp">About Us</a>&nbsp;&nbsp;
    <a href="home.jsp">Home</a>&nbsp;&nbsp;
    <a href="logout">Logout</a>
</body>

</html>