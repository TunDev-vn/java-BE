package vn.com.t3h.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<ProductEntity> productEntities = productService.findAll();
        model.addAttribute("products", productEntities);
        return "product-list";
    }
}
