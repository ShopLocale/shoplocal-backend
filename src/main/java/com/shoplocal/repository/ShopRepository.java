package com.shoplocal.repository;

import java.util.List;
import com.shoplocal.entity.Shop;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
@Configuration
@Repository
public interface ShopRepository extends JpaRepository<Shop, UUID> {

    @Query("SELECT s FROM Shop s inner join Address a on s.address = a where (a.pinCode = :pinCode)")
    List<Shop> findByPin(@Param("pinCode") String pinCode);

}
