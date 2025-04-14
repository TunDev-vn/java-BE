package vn.com.t3h.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.processing.SupportedOptions;

/*
@Controller: trả về dữ liệu dạng html, file view
 */
@Controller
@Scope("prototype")
public class HomeController {
    /*
    GetMapping: sử dụng phương thức http get
    PostMapping: sử dụng phương thức http post
     */
    @GetMapping("/home")
    public String getHome(){
        // trả về tên file trang-chu.jsp
        return "trang-chu";
    }
}
