package vn.com.t3h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.t3h.entity.RoleEntity;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByCodeAndDeletedIsFalse(String code);


//    Trường hợp dùng FetchType.LAZY phải thêm thủ công hàm lấy role
    @Query(value = "select role from RoleEntity role " +
            "join role.users user where user.username = :username")
    Set<RoleEntity> findByUserName(String username);
}
