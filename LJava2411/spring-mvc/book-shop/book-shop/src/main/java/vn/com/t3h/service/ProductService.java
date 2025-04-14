package vn.com.t3h.service;

import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.model.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    public List<ProductDTO> searchProducts(Double price, String bookTitle, String publisher, String categoryName);

    public ProductDTO addProduct(ProductDTO productDto);
}
