package webanime.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"//loginsession"})
public class LoginServletSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && username.equals("trungnh") && password.equals("123")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("name", username);
            session.setMaxInactiveInterval(30 * 60); // Session hết hạn sau 30 phút
            out.print("Chào mừng bạn, " + username);
            response.sendRedirect(request.getContextPath() + "/hello"); // Chuyển đến trang chính
        } else {
            out.print("Tài khoản hoặc mật khẩu không chính xác");
            request.getRequestDispatcher("/Loginsession.html").include(request, response);
        }
        out.close();
    }
}