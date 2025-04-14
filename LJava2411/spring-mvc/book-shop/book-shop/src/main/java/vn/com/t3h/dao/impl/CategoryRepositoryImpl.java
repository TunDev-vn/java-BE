package vn.com.t3h.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.CategoryRepository;
import vn.com.t3h.entity.CategoryEntity;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CategoryEntity findByName(String name) {
        // Lấy session từ sessionFactory
        Session session = sessionFactory.openSession();
        // Sử dụng HQL (Hibernate Query Language) để tìm kiếm CategoryEntity theo tên
        Query<CategoryEntity> query = session.createQuery("FROM CategoryEntity WHERE categoryName = :name", CategoryEntity.class);
        query.setParameter("name", name);
        // Trả về đối tượng CategoryEntity đầu tiên hoặc null nếu không tìm thấy
        return query.uniqueResult();
    }
}

