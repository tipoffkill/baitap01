package webanime.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/hello-session"})
public class HelloSessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        HttpSession session = req.getSession(false); 
        String name = null;
        if (session != null) {
            name = (String) session.getAttribute("username");
        }

        if (name == null) {
            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println("Xin chào (session): " + name);
            resp.getWriter().println("<br><a href='" + req.getContextPath() + "/logout-session'>Logout</a>");
        }

    }
}
