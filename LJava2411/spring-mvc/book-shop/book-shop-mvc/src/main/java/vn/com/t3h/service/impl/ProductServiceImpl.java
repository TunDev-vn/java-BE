package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.ProductRepository;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.model.ProductDTO;
import vn.com.t3h.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("productHibernateRepositoryImpl")
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDTO> findByCondition(Double price, String bookTitle, String publisher, String categoryName) {
        List<ProductEntity> productEntities =  productRepository.findByCondition(price, bookTitle, publisher, categoryName);
        List<ProductDTO> productDTOS = productEntities.stream().map(data -> {
            ProductDTO productDTO = new ProductDTO(data.getId(),
                    data.getBookTitle(), data.getAuthor(), data.getPageCount(),
                    data.getPublisher(), data.getPublicationYear(), data.getGenre(),
                    data.getPrice(), data.getDiscount(), data.getStockQuantity(),
                    data.getDescription());
            return productDTO;
        }).collect(Collectors.toList());
        return productDTOS;
    }
}
