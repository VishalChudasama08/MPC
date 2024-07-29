<html>
<head>
    <style>
        #main{
            display: flex;
            flex-flow: row;
        }
        #p13, img {
            width: 888px;
        }
        div {
            border: 2px solid green;
        }
    </style>
</head>
<body>
<h2>Hello World!</h2>
<div id="main">
    <div id="p13">
        Servlet Program 13 =>
        <br>
        <img src="img.png" />
    </div>

    <div>
        Servlet Program 14 =><br>

        <div>
            page import="java.time.LocalDate" <%@ page import="java.time.LocalDate" %>
        </div><br>

        <div>
            <!-- declaration tag declare any thing -->
            <%!
                int a = 8;
                String name = "Vishal";
                int square(){
                    return a*a;
                }
            %>

            <!-- scriptlet tag -->
            <%
                out.println("a : " + a);
                out.println("Name : " + name);

                int b = 20; //local variable

                if(b<456){
                    out.println("b is smaller than 456");
                } else {
                    out.println("b is greater than 456");
                }

                for(int i=1; i<=5; i++){
                    out.println(i);
                }
            %>
        </div><br>

        <div>
            <%= a %>
            <%= name %>
            <%= square() %>

            <%= LocalDate.now() %>

            <%= Math.random() %>
        </div>
        <a href="example.jsp"> more tags example </a>
    </div>

</div>
</body>
</html>
