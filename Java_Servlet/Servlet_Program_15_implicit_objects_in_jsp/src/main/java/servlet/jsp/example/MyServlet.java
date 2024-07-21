package servlet.jsp.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/javaFile")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter(); // need to create PrintWriter Object for print
        out.println("<p>Hey, i am MyServlet.java file out.println(), For print need to create PrintWriter object</p>");

        HttpSession session = req.getSession(); // need to create HttpSession object to use session
        session.setAttribute("session_name", "I am 'MyServlet.java_file_session', For using session in java file need to create HttpSession object");
        out.println("<p>"+session.getAttribute("session_name")+"</p>");
        out.println("<a href='index.jsp'>Go Index.jsp page</a>");
    }
}
