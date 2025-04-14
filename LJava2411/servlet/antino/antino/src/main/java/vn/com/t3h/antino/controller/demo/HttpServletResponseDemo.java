package vn.com.t3h.antino.controller.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/response-demo")
public class HttpServletResponseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Thiết lập trạng thái HTTP
        response.setStatus(HttpServletResponse.SC_OK); // Mã trạng thái 200 (OK)
        // 2. Thiết lập header HTTP
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Custom-Header", "DemoHeader");
        // 3. Gửi dữ liệu phản hồi
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>HttpServletResponse Demo</h1>");
        response.getWriter().println("<p>Trạng thái: 200 OK</p>");
        response.getWriter().println("<p>Header 'Custom-Header': DemoHeader</p>");
        response.getWriter().println("</body></html>");
        // 4. Thêm cookie
        Cookie userCookie = new Cookie("username", "JohnDoe");
        userCookie.setMaxAge(60 * 60); // Cookie tồn tại trong 1 giờ
        response.addCookie(userCookie);
        // 5. Chuyển hướng (nếu cần)
        // response.sendRedirect("https://www.example.com");
    }
}

/**

 */