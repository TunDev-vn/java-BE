package vn.com.t3h.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.t3h.entity.UserEntity;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    @Query(value = "select u from UserEntity u" +
            " where (:code is null or u.code = :code) " +
            " and (:fromDate is null or u.createdDate >= :fromDate)" +
            " and (:toDate is null or u.createdDate <= :toDate) " +
            " and (:phone is null or u.phone = :phone)")
    Page<UserEntity> search(
            String code,
            LocalDate fromDate,
            LocalDate toDate,
            String phone,
            Pageable pageable);


    UserEntity findByUsername(String username);
}
