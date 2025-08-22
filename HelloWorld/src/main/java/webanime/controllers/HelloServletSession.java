package webanime.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/hello"})
public class HelloServletSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false); // Không tạo session mới nếu không tồn tại

        if (session != null) {
            String name = (String) session.getAttribute("name");
            if (name != null) {
                out.print("Chào bạn, " + name + " đến với trang quản lý tài khoản");
                out.print("<br><a href='" + request.getContextPath() + "/logout'>Logout</a>");
            } else {
                out.print("Xin vui lòng đăng nhập");
                response.sendRedirect(request.getContextPath() + "/Loginsession.html");
            }
        } else {
            out.print("Xin vui lòng đăng nhập");
            response.sendRedirect(request.getContextPath() + "/Loginsession.html");
        }
        out.close();
    }
}