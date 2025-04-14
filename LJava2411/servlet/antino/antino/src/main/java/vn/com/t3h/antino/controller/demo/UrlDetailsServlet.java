package vn.com.t3h.antino.controller.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 Toàn bộ URL: http://localhost:8080/test/request/sample1?value
 Scheme: http://
 ServerName: localhost
 ServerPort: 8080
 ContextPath: /test
 ServletPath: /request/sample1
 QueryString: ?value

 */

import java.io.IOException;

@WebServlet(name = "UrlDetailsServlet",value = "/request/sample1") // ServletPath
public class UrlDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy các thành phần của URL
        String scheme = request.getScheme(); // http hoặc https
        String serverName = request.getServerName(); // localhost hoặc IP
        int serverPort = request.getServerPort(); // Cổng 8080
        String contextPath = request.getContextPath(); // /test
        String servletPath = request.getServletPath(); // /request/sample1
        String queryString = request.getQueryString(); // value (nếu có)

        // Gửi phản hồi tới client
        response.setContentType("text/html");
        response.getWriter().println("<h1>Chi tiết URL</h1>");
        response.getWriter().println("<ul>");
        response.getWriter().println("<li><b>Scheme:</b> " + scheme + "</li>");
        response.getWriter().println("<li><b>Server Name:</b> " + serverName + "</li>");
        response.getWriter().println("<li><b>Server Port:</b> " + serverPort + "</li>");
        response.getWriter().println("<li><b>Context Path:</b> " + contextPath + "</li>");
        response.getWriter().println("<li><b>Servlet Path:</b> " + servletPath + "</li>");
        response.getWriter().println("<li><b>Query String:</b> " + queryString + "</li>");
        response.getWriter().println("</ul>");
    }
}
