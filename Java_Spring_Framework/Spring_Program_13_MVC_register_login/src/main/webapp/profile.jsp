<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="spring.servlet.user.User" %>
<%-- write this line to import User class in this file (profile.jsp) for use User class  --%>
<html>
<body>
    <h3 style="color:orange"> Welcome! </h3>
    <% User user = (User) session.getAttribute("user"); %>
    <%-- getAttribute() method return in Object but i get value in User class than typecast in User --%>
    
    <h3>Name : <%= user.getName() %></h3>
    <h3>Email : <%= user.getEmail() %></h3>
    <h3>City : <%= user.getCity() %></h3>

    <a href="logout" >Logout</a>
</body>
</html>


