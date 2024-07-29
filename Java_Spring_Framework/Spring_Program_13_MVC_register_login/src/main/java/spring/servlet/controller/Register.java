package spring.servlet.controller;

import spring.servlet.mysql.DbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/regForm") // if annotation not sowing red underline than, add mysql-connector-j-8.4.0.jar file
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String city = req.getParameter("city");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        try {
            Connection conn = DbConnect.getConnection(); // using another class method to get connection

            PreparedStatement ps = conn.prepareStatement("INSERT INTO `register` VALUES (?, ?, ?, ?, ?);");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, gender);
            ps.setString(5, city);

            int count = ps.executeUpdate();
            if(count > 0){
                out.println("<h3 style='color:green'> User registered successfully </h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/login.html");
                rd.include(req, resp);
            } else {
                out.println("<h3 style='color:red'> User not registered due to some error </h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/register.html");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            out.println("<h3 style='color:red'> Exception : "+e.getMessage()+" </h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.html");
            rd.include(req, resp);
        }
    }
}
