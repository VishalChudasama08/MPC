<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Servlet_Program_09_RequestDispatcher_interface_open_new_file_withot_chenge_url Maven Webapp. aboutUs.jsp page
    </title>
</head>

<body>
    <%
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
    %>
    <h3>About Us</h3>
    <p>Name: <%= name %></p>
    <p>Email: <%= email %></p>
    <a href="home.jsp">Home</a>&nbsp;&nbsp;
    <a href="services.jsp">Services</a>&nbsp;&nbsp;
    <a href="logout">Logout</a>
</body>

</html>