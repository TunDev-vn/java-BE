package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.CategoryRepository;
import vn.com.t3h.dao.ProductRepository;
import vn.com.t3h.entity.CategoryEntity;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.model.ProductDTO;
import vn.com.t3h.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("productHibernateRepositoryImpl")
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<ProductDTO> searchProducts(Double price, String bookTitle, String publisher, String categoryName) {
        return productRepository.searchProducts(price, bookTitle, publisher, categoryName);
    }

    public ProductDTO addProduct(ProductDTO productDto) {
        CategoryEntity category = categoryRepository.findByName(productDto.getCategoryName());
        if (category == null) {
            throw new RuntimeException("Category not found");
        }

        ProductEntity product = new ProductEntity();
        product.setAuthor(productDto.getAuthor());
        product.setBookTitle(productDto.getBookTitle());
        product.setDescription(productDto.getDescription());
        product.setDiscount(productDto.getDiscount());
        product.setGenre(productDto.getGenre());
        product.setPageCount(productDto.getPageCount());
        product.setPrice(productDto.getPrice());
        product.setPublicationYear(productDto.getPublicationYear());
        product.setPublisher(productDto.getPublisher());
        product.setStockQuantity(productDto.getStockQuantity());
        product.setCategory(category);

        Integer prodId = productRepository.saveProduct(product);
        productDto.setId(prodId);
        return productDto;
    }

}
