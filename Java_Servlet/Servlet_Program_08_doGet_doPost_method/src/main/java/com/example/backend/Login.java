package com.example.backend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class Login extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("email");
//        String password = req.getParameter("password");
//
//        if(username.equals("okay@gmail.com") && password.equals("123")){
//            System.out.println("Success");
//        } else  {
//            System.out.println("failed");
//        }
//    }


    // this service method - if get method and if post both work
    // but you use only post than do it 'service' -> "doPost" only name change
    // if use get than 'service' -> "doGet",
    // Note: "service" method work in both case, but use use like if post method than do this (System.out.println("Success");) than use doPost


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("email");
//        String password = req.getParameter("password");
//
//        if(username.equals("okay@gmail.com") && password.equals("123")){
//            System.out.println("Success");
//        } else  {
//            System.out.println("failed");
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");

        if(username.equals("okay@gmail.com") && password.equals("123")){
            System.out.println("Success");
        } else  {
            System.out.println("failed");
        }
    }
}
