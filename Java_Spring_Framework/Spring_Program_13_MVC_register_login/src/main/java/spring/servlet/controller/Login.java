package spring.servlet.controller;

import spring.servlet.mysql.DbConnect;
import spring.servlet.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/loginForm") // if annotation not sowing red underline than, add mysql-connector-j-8.4.0.jar file
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        try {
            Connection conn = DbConnect.getConnection(); // using another class method to get connection

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM `register` WHERE email=? and password=?;");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                out.println("<h3 style='color:green'> User Login successfully </h3>");
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCity(rs.getString("city"));

                HttpSession session = req.getSession();
                session.setAttribute("user", user); // set user all data in session using User class object


                RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
                rd.include(req, resp);
            } else {
                out.println("<h3 style='color:red'> Email id and password did not matched </h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/login.html");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            out.println("<h3 style='color:red'> Exception : "+e.getMessage()+"</h3>");
            out.println(e);
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.include(req, resp);
        }
    }
}
