package vn.com.t3h.antino.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.antino.model.UserModel;
import vn.com.t3h.antino.util.SessionUtil;

import java.io.IOException;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy current user thông qua session, để kiểm tra xem user đã đăng nhập chưa
        UserModel currentUser = (UserModel) SessionUtil.getValue(req, SessionUtil.SESSION_ID_CURRENT_USER);
        if (currentUser == null) {
            System.out.println("Current User is null");
        } else {
            System.out.println("Current User: " + currentUser.toString());
        }
        req.setAttribute("currentUser", currentUser);
        req.setAttribute("message", "hello");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home-page.jsp");
        requestDispatcher.forward(req, resp);
    }
}
