package vn.com.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "home"; // tên file JSP sẽ là hello.jsp
    }
}
