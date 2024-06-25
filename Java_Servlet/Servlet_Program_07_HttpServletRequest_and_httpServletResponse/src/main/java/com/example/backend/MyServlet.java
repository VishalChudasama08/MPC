package com.example.backend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/data")
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String useremail = req.getParameter("email");

        // print in console
        System.out.println("Name: " + username);
        System.out.println("Email: " + useremail);

        PrintWriter out = resp.getWriter(); // create object for use it print in browser page
        // print in browser page
        out.println("Name: " + username);
        out.println("Email: " + useremail);
    }
}
