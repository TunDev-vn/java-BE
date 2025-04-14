package vn.com.t3h.dao;

import vn.com.t3h.entity.CategoryEntity;

public interface CategoryRepository {

    CategoryEntity findByName(String name);
}
