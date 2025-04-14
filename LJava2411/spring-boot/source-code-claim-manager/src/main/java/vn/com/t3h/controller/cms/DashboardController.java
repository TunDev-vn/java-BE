package vn.com.t3h.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // khai báo đây là 1 controller sẽ trả về view html
@RequestMapping("/cms") // làm gốc url cho tất cả các method trong controller
public class DashboardController {


    @GetMapping("/dashboard")
    public String getDashboard() {
        return "cms/dashboard";
    }
}
