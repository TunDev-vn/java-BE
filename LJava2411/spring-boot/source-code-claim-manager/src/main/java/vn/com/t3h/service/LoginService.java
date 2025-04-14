package vn.com.t3h.service;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface LoginService {

    public String processAfterLoginSuccess(Model model, HttpSession session);
}
