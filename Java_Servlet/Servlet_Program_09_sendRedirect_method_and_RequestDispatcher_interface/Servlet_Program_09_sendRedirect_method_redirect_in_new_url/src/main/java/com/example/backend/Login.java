package com.example.backend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/formSubmitted")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchText = req.getParameter("search1");
//        resp.sendRedirect("https://www.google.com"); // user to change url. this go on google.com only
        resp.sendRedirect("https://www.google.com/search?q=" + searchText); // // user to change url. this go on google.com only
        // sendRedirect() method redirect new provided string page (here -> https://www.google.com/search?q=) with value (here searchText value)
        // here -> with provided value and go on google.com page and search this value on Google
    }
}