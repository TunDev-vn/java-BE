package vn.com.t3h.antino.controller.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/demo-request")
public class HttpServletRequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập nội dung phản hồi dạng HTML
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        // 1. Truy xuất thông tin yêu cầu HTTP
        String method = request.getMethod(); // Phương thức HTTP (GET, POST, ...)
        String requestURL = request.getRequestURL().toString(); // URL đầy đủ
        String queryString = request.getQueryString(); // Chuỗi truy vấn (query string)
        String parameter = request.getParameter("name"); // Tham số trong URL hoặc form

        // 2. Quản lý phiên làm việc (Session)
        HttpSession session = request.getSession();
        session.setAttribute("user", "GuestUser"); // Gán giá trị vào session
        String sessionId = session.getId(); // Lấy ID của session

        // 3. Truy cập header HTTP
        String userAgent = request.getHeader("User-Agent"); // Lấy thông tin trình duyệt
        String contentType = request.getHeader("Content-Type"); // Kiểu nội dung

        // 4. Xử lý dữ liệu từ form HTML (ví dụ với tham số "email")
        String email = request.getParameter("email");

        // Tạo nội dung HTML hiển thị kết quả
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Thông tin HttpServletRequest</h1>");

        // Hiển thị thông tin yêu cầu HTTP
        response.getWriter().println("<h2>1. Thông tin yêu cầu HTTP:</h2>");
        response.getWriter().println("<p><b>Phương thức HTTP:</b> " + method + "</p>");
        response.getWriter().println("<p><b>URL:</b> " + requestURL + "</p>");
        response.getWriter().println("<p><b>Chuỗi truy vấn:</b> " + queryString + "</p>");
        response.getWriter().println("<p><b>Tham số 'name':</b> " + parameter + "</p>");

        // Hiển thị thông tin session
        response.getWriter().println("<h2>2. Thông tin phiên làm việc (Session):</h2>");
        response.getWriter().println("<p><b>ID phiên:</b> " + sessionId + "</p>");
        response.getWriter().println("<p><b>Giá trị 'user' trong session:</b> " + session.getAttribute("user") + "</p>");

        // Hiển thị thông tin header HTTP
        response.getWriter().println("<h2>3. Thông tin header HTTP:</h2>");
        response.getWriter().println("<p><b>User-Agent:</b> " + userAgent + "</p>");
        response.getWriter().println("<p><b>Content-Type:</b> " + contentType + "</p>");

        // Hiển thị thông tin dữ liệu từ form
        response.getWriter().println("<h2>4. Dữ liệu từ form HTML:</h2>");
        response.getWriter().println("<p><b>Email:</b> " + email + "</p>");

        response.getWriter().println("</body></html>");
    }
}