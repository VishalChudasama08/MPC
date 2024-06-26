package com.example.backend;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        // RequestDispatcher interface no use karvathi url ma nay badalav thato nathi pan, je file open karvi hoy te thay jay chhe,
        // this is very usefull and secure method to open new file
        if(username.equals("okay@gmail.com") && password.equals("123")){
            System.out.println("Success");
            request.setAttribute("name", "Vishal");
            RequestDispatcher rd = request.getRequestDispatcher("/home.jsp"); // create object for -> je file ma javanu chhe te file mate RequestDispatcher no object
            rd.forward(request, response); // aa request ne forward karo response ma, ask to open /home.jsp file
        } else  {
            System.out.println("failed");
            response.setContentType("text/html"); // use karvathi include() kareli file html file tarike run tha chhe
            // include() method index.html file no source code print kare chhe, pan setContentType() method no use kariye to tem thatu nathi
            // etle index.html file html file tarike browser ma run thay chhe
            out.println("<h3 style='color:red;'>Email id and Password didn't matched</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
//            rd.forward(request, response);
            rd.include(request, response); // include() method no use karvathi response file ma biju pan add karisakay,
            // jemke ahi line (out.println("Email id and Password didn't match")); include() method no ues kari toj out put ma aave chhe
            // pan include() method index.html file no source code print kare chhe browser ma
        }
    }
}