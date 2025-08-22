package webanime.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"//", "/home/", "/trangchu"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
 
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("ten");
        
        // Lấy writer để ghi ra response
        PrintWriter out = resp.getWriter();

        try {
            out.println("<html>");
            out.println("<head><title>HomeController</title></head>");
            out.println("<body>");
            out.println("<h1>Hello World từ HomeController! </h1>"+name);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
    // Set response content type
     response.setContentType("text/html");
     response.setCharacterEncoding("UTF-8");
     request.setCharacterEncoding("UTF-8");
     //Nhận dữ liệu từ request URL
     String ten = request.getParameter("ten");
     String holot = request.getParameter("holot");
    //Hiển thị dữ liệu ra web bằng đối tượng PrintWriter
     PrintWriter out = response.getWriter();
    out.println("<b>First Name</b>: " + ten + "<br/><b>Last Name</b>: "+ holot);
    }
}