package vn.com.t3h.antino.security;


import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    public String login(String username, String password, HttpServletRequest request);
}
