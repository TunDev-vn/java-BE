package vn.com.t3h.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.ProductRepository;
import vn.com.t3h.entity.CategoryEntity;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.model.ProductDTO;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository("productHibernateRepositoryImpl")
public class ProductHibernateRepositoryImpl implements ProductRepository {

    private final SessionFactory sessionFactory;

    public ProductHibernateRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        // Mở session Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Tạo truy vấn HQL để lấy tất cả sản phẩm
            String hql = "FROM ProductEntity";  // HQL để lấy tất cả bản ghi từ bảng ProductEntity
            Query<ProductEntity> query = session.createQuery(hql, ProductEntity.class);
            // Thực thi truy vấn và lấy danh sách sản phẩm
            List<ProductEntity> productList = query.getResultList();

            String hql2 = "SELECT p.bookTitle, p.author FROM ProductEntity p";
            List<Object[]> results = session.createQuery(hql2).getResultList();

            String hql3= "FROM ProductEntity p WHERE p.price > :price";
            Query<ProductEntity> query3 = session.createQuery(hql3);
            query.setParameter("price", 100.0);
            List<ProductEntity> productList2 = query.getResultList();

            String hql4 = "FROM ProductEntity p ORDER BY p.price DESC";
            List<ProductEntity> productList4 = session.createQuery(hql4).getResultList();

            String hql5 = "SELECT p FROM ProductEntity p JOIN p.category c WHERE c.categoryName = :categoryName";
            Query<ProductEntity> query5 = session.createQuery(hql5);
            query.setParameter("categoryName", "Fiction");
            List<ProductEntity> productList5 = query.getResultList();



            return productList;  // Trả về danh sách sản phẩm
        }
    }
    @Override
    public List<ProductDTO> searchProducts(Double price, String bookTitle, String publisher, String categoryName) {
        // Mở session Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Xây dựng câu truy vấn HQL với các tiêu chí tìm kiếm
            StringBuilder hql = new StringBuilder("SELECT new vn.com.t3h.model.ProductDTO(p.id, p.bookTitle, p.author, p.price, p.publisher, " +
                    "p.pageCount, p.publicationYear, p.genre, p.discount, p.stockQuantity, p.description, p.category.categoryName) " +
                    "FROM ProductEntity p WHERE 1=1");

            // Thêm điều kiện cho từng tiêu chí tìm kiếm nếu chúng được truyền vào
            if (price != null) {
                hql.append(" AND p.price = :price");  // Đặt tên tham số rõ ràng
            }
            if (bookTitle != null && !bookTitle.isEmpty()) {
                hql.append(" AND p.bookTitle LIKE :bookTitle");
            }
            if (publisher != null && !publisher.isEmpty()) {
                hql.append(" AND p.publisher LIKE :publisher");
            }
            if (categoryName != null && !categoryName.isEmpty()) {
                hql.append(" AND p.category.categoryName LIKE :categoryName");
            }

            // Tạo truy vấn HQL
            Query<ProductDTO> query = session.createQuery(hql.toString(), ProductDTO.class);

            // Thiết lập các tham số của truy vấn
            if (price != null) {
                query.setParameter("price", price);  // Đảm bảo thiết lập tham số price
            }
            if (bookTitle != null && !bookTitle.isEmpty()) {
                query.setParameter("bookTitle", "%" + bookTitle + "%");  // Đảm bảo thiết lập tham số bookTitle
            }
            if (publisher != null && !publisher.isEmpty()) {
                query.setParameter("publisher", "%" + publisher + "%");  // Đảm bảo thiết lập tham số publisher
            }
            if (categoryName != null && !categoryName.isEmpty()) {
                query.setParameter("categoryName", "%" + categoryName + "%");  // Đảm bảo thiết lập tham số categoryName
            }

            // Thực thi truy vấn và trả về danh sách sản phẩm DTO
            List<ProductDTO> productDTOList = query.getResultList();
            return productDTOList;
        }
    }

    public List<ProductDTO> searchProductsCriteria(Double price, String bookTitle, String publisher, String categoryName) {
        // Mở session Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Tạo đối tượng CriteriaBuilder và CriteriaQuery
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ProductDTO> criteriaQuery = criteriaBuilder.createQuery(ProductDTO.class);
            // Tạo Root cho ProductEntity
            Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);
            // Tạo các tiêu chí tìm kiếm (Predicates)
            List<Predicate> predicates = new ArrayList<>();
            // Thêm các điều kiện tìm kiếm
            if (price != null) {
                predicates.add(criteriaBuilder.equal(root.get("price"), price));  // Điều kiện price
            }
            if (bookTitle != null && !bookTitle.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("bookTitle"), "%" + bookTitle + "%"));  // Điều kiện bookTitle
            }
            if (publisher != null && !publisher.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("publisher"), "%" + publisher + "%"));  // Điều kiện publisher
            }
            if (categoryName != null && !categoryName.isEmpty()) {
                // Tạo điều kiện cho categoryName, vì category là một đối tượng con
                Join<ProductEntity, CategoryEntity> categoryJoin = root.join("category", JoinType.INNER);
                predicates.add(criteriaBuilder.like(categoryJoin.get("categoryName"), "%" + categoryName + "%"));  // Điều kiện categoryName
            }
            // Áp dụng tất cả các điều kiện vào CriteriaQuery
            criteriaQuery.select(criteriaBuilder.construct(
                    ProductDTO.class,
                    root.get("id"),
                    root.get("bookTitle"),
                    root.get("author"),
                    root.get("price"),
                    root.get("publisher"),
                    root.get("pageCount"),
                    root.get("publicationYear"),
                    root.get("genre"),
                    root.get("discount"),
                    root.get("stockQuantity"),
                    root.get("description"),
                    root.get("category").get("categoryName")
            )).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            // Tạo truy vấn và thực thi
            Query<ProductDTO> query = session.createQuery(criteriaQuery);
            List<ProductDTO> productDTOList = query.getResultList();
            return productDTOList;
        }
    }

    public Integer saveProduct(ProductEntity product) {
        // Mở Session
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer productId = null;

        try {
            // Bắt đầu giao dịch
            transaction = session.beginTransaction();

            // Lưu sản phẩm và lấy id
            productId = (Integer) session.save(product); // Lưu và lấy id của sản phẩm

            // Cam kết giao dịch
            transaction.commit();
        } catch (Exception e) {
            // Nếu có lỗi, rollback giao dịch
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng session
            session.close();
        }

        // Trả về id của sản phẩm đã được lưu
        return productId;
    }





}
