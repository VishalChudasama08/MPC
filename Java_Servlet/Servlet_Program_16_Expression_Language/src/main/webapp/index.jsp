<html>
<body>
    <h1> Not Working </h1>
    <%
        request.setAttribute("request_name", "Chudasama");
        // out.println(request.getAttribute("request_name"));
    %>
    <h3> Hello : ${requestScope.request_name} <!-- this is Expression Language -->
    <!-- 'request_name' is request Attribute name  -->

    <%
       session.setAttribute("session_name", "Vishal");
    %>
    ${session_name} </h3>
    <h3>Some implicit object in expression language are :-</h3>
    <img style="width:800px" src="implicit_object_in_expression_language.png" />
</body>
</html>
