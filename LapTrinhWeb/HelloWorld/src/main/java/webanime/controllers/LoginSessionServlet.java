package webanime.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/login-session"})
public class LoginSessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if (user != null && pass != null && user.equals("trung") && pass.equals("123")) {
            // Tạo session
            HttpSession session = req.getSession();
            session.setAttribute("username", user);

            resp.sendRedirect(req.getContextPath() + "/hello-session");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.html?error=InvalidCredentials");
        }
    }
}
