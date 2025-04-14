package vn.com.t3h.antino.controller.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ForwardExample")
public class ForwardExample extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập một thuộc tính để gửi đến tài nguyên khác
        request.setAttribute("message", "Xin chào từ ForwardExample!");
        // Sử dụng RequestDispatcher để chuyển tiếp yêu cầu đến TargetServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TargetServlet");
        dispatcher.forward(request, response);
    }
}