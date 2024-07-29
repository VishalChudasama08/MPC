<!-- JSP Directive Tags for page configuration and import -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enhanced JSP Tag Examples</title>
</head>
<body>
    <h1>Enhanced JSP Tag Examples</h1>

    <!-- Declaration Tag: Declaring a variable -->
    <%!
        private String message = "Hello, JSP!";
        private Date currentDate = new Date();
    %>

    <!-- Expression Tag: Outputting the value of the variable -->
    <p>Message: <%= message %></p>
    <p>Current Date and Time: <%= currentDate %></p>

    <!-- Scriptlet Tag: Using Java code within HTML -->
    <%
        int number1 = 5;
        int number2 = 10;
        int sum = number1 + number2;
    %>
    <p>Sum of <%= number1 %> and <%= number2 %> is: <%= sum %></p>

    <!-- Conditional Logic using Scriptlet Tag -->
    <%
        if (sum > 10) {
    %>
        <p>The sum is greater than 10.</p>
    <%
        } else {
    %>
        <p>The sum is 10 or less.</p>
    <%
        }
    %>

    <!-- Loop using Scriptlet Tag -->
    <p>Loop from 1 to 5:</p>
    <ul>
    <%
        for (int i = 1; i <= 5; i++) {
    %>
        <li>Number: <%= i %></li>
    <%
        }
    %>
    </ul>

    <!-- JSP Comment Tag -->
    <%-- This is a JSP comment and it will not appear in the HTML output --%>

    <!-- HTML Comment -->
    <!-- This is an HTML comment and it will appear in the HTML source code -->

    <!-- Standard Action Tags -->
    <!-- Use Bean Tag: Creates an instance of a JavaBean -->
    <jsp:useBean id="user" class="com.example.User" scope="session"/>

    <!-- Set Property Tag: Sets a property of the JavaBean -->
    <jsp:setProperty name="user" property="name" value="John Doe"/>

    <!-- Get Property Tag: Retrieves a property of the JavaBean -->
    <p>User Name: <jsp:getProperty name="user" property="name"/></p>

    <!-- Include Tag: Includes another resource -->
    <jsp:include page="footer.jsp"/>

    <!-- Forward Tag: Forwards to another resource -->
    <%-- <jsp:forward page="anotherPage.jsp"/> --%>

    <!-- JSTL Core Tags -->
    <c:if test="${sum > 10}">
        <p>The sum is greater than 10 (checked using JSTL).</p>
    </c:if>

    <c:forEach var="i" begin="1" end="5">
        <p>Number (using JSTL): ${i}</p>
    </c:forEach>
</body>
</html>
