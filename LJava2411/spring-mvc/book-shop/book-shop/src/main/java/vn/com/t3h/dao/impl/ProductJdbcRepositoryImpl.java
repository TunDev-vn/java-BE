package vn.com.t3h.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.ProductRepository;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.model.ProductDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("productJdbcRepositoryImpl")
public class ProductJdbcRepositoryImpl implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Lấy tất cả sản phẩm
    public List<ProductEntity> getAllProducts() {
        String sql = "SELECT * FROM products";
        // Sử dụng RowMapper trực tiếp trong phương thức
        return jdbcTemplate.query(sql, new RowMapper<ProductEntity>() {
            @Override
            public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProductEntity product = new ProductEntity();

                product.setId(rs.getInt("id"));
                product.setBookTitle(rs.getString("book_title"));
                product.setAuthor(rs.getString("author"));
                product.setPageCount(rs.getInt("page_count"));
                product.setPublisher(rs.getString("publisher"));
                product.setPublicationYear(rs.getInt("publication_year"));
                product.setGenre(rs.getString("genre"));
                product.setPrice(rs.getDouble("price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                product.setDescription(rs.getString("description"));

                return product;
            }
        });
    }

    @Override
    public List<ProductDTO> searchProducts(Double price, String bookTitle, String publisher, String categoryName) {
        return new ArrayList<>();
    }

    @Override
    public Integer saveProduct(ProductEntity product) {
        return 0;
    }

    // Thêm sản phẩm mới
    public int addProduct(ProductEntity product) {
        String sql = "INSERT INTO products (book_title, author, page_count, publisher, publication_year, " +
                "genre, price, discount, stock_quantity, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, product.getBookTitle(), product.getAuthor(), product.getPageCount(),
                product.getPublisher(), product.getPublicationYear(), product.getGenre(), product.getPrice(),
                product.getDiscount(), product.getStockQuantity(), product.getDescription());
    }

    // Cập nhật thông tin sản phẩm
    public int updateProduct(ProductEntity product) {
        String sql = "UPDATE products SET book_title = ?, author = ?, page_count = ?, publisher = ?, " +
                "publication_year = ?, genre = ?, price = ?, discount = ?, stock_quantity = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, product.getBookTitle(), product.getAuthor(), product.getPageCount(),
                product.getPublisher(), product.getPublicationYear(), product.getGenre(), product.getPrice(),
                product.getDiscount(), product.getStockQuantity(), product.getDescription(), product.getId());
    }

    // Xóa sản phẩm
    public int deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
