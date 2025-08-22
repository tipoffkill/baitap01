package webanime.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html");
	    String user = req.getParameter("username");
	    String pass = req.getParameter("password");

	    if (user != null && pass != null && user.equals("trung") && pass.equals("123")) {
	        Cookie cookie = new Cookie("username", user);
	        cookie.setMaxAge(30);
	        resp.addCookie(cookie);
	        resp.sendRedirect(req.getContextPath() + "/hello"); 
	    } else {
	        resp.sendRedirect(req.getContextPath() + "/login.html?error=InvalidCredentials"); 
	    }
	}

}
