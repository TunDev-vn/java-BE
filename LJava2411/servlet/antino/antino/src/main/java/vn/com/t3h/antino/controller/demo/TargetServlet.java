package vn.com.t3h.antino.controller.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/TargetServlet")
public class TargetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thuộc tính được chuyển từ servlet ban đầu
        String message = (String) request.getAttribute("message");
        response.setContentType("text/html");
        response.getWriter().println("<h1>" + message + "</h1>");
    }
}