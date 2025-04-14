package vn.com.t3h.dao;

import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.model.ProductDTO;

import java.util.List;

public interface ProductRepository {

    List<ProductEntity> getAllProducts();

    public List<ProductDTO> searchProducts(Double price, String bookTitle, String publisher, String categoryName);

    public Integer saveProduct(ProductEntity product);
}
