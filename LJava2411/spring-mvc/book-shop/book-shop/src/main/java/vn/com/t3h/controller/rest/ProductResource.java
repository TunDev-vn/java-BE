package vn.com.t3h.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.model.ProductDTO;
import vn.com.t3h.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }
    // GET http://localhost:8080/api/products/search?price=150.75&bookTitle=GzTq3KJp&publisher=Y0tWb9Nm&categoryName=FaVtC3Xs
    // Lấy danh sách sản phẩm theo các tiêu chí
    @GetMapping(value = "/search", produces = "application/json")
    public ResponseEntity<List<ProductDTO>> searchProducts(
            @RequestParam(required = false,name = "price") Double price,              // price là tham số tìm kiếm, có thể null
            @RequestParam(required = false,name = "bookTitle") String bookTitle,          // bookTitle là tham số tìm kiếm, có thể null
            @RequestParam(required = false,name = "publisher") String publisher,          // publisher là tham số tìm kiếm, có thể null
            @RequestParam(required = false,name = "categoryName") String categoryName) {     // categoryName là tham số tìm kiếm, có thể null

        // Gọi service để tìm kiếm các sản phẩm theo các tham số
        List<ProductDTO> products = productService.searchProducts(price, bookTitle, publisher, categoryName);
        return ResponseEntity.ok(products);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) {
        ProductDTO productDTO = productService.addProduct(product);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        // Tìm sản phẩm theo ID
//        ProductDTO product = productService.getProductById(id);
//        return ResponseEntity.ok(product);
        return null;
    }

}
