<%@ page import="in.v8.main.entities.Users" %>
<%
   // Retrieve the loggedInUser from session
   Users loggedInUser = (Users) session.getAttribute("loggedInUser");
%>