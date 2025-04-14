package vn.com.t3h.dao;

import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.model.ProductDTO;

import java.util.List;

public interface ProductRepository {

    List<ProductEntity> findAll();

    public List<ProductEntity> findByCondition(Double price, String bookTitle,String publisher,String categoryName);
}
