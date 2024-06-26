<!-- <%-- <%@ page laguage="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %> --%> -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Servlet_Program_09_RequestDispatcher_interface_open_new_file_withot_chenge_url Maven Webapp. home.jsp page
    </title>
</head>

<body>
    <%
        String name = (String) request.getAttribute("name");
    %>
    <h3>Welcome : <%= name %> </h3>
</body>

</html>