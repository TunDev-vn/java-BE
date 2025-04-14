package vn.com.t3h.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.model.ProductDTO;
import vn.com.t3h.service.ProductService;

import java.util.List;
/**
 Bài tập 1:
    viết api lấy danh sách các thông tin của user với các yêu cầu
    url: localhost:8080/api/users
    method: GET
    công nghệ sử dụng:
        hibernate, hql, entity user
 Bài 2:
    từ api lấy danh sách user, sửa api đó thành api cho phép tìm kiếm user theo các tiêu chí sau
    - username hoặc full_name , truyền dữ liệu theo kiểu param
    - gợi ý: join với bảng identity_cards để tìm kiếm theo ful name, sử dụng entity để join

 */
@RestController
@RequestMapping("/api/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> search(@RequestParam(required = false,name = "price") Double price,
                                                   @RequestParam(required = false,name = "bookTitle") String bookTitle,
                                                   @RequestParam(required = false,name = "publisher") String publisher,
                                                   @RequestParam(required = false,name = "categoryName") String categoryName) {
        List<ProductDTO> productEntities = productService.findByCondition(price, bookTitle, publisher, categoryName);
        return ResponseEntity.ok(productEntities);
    }
}
