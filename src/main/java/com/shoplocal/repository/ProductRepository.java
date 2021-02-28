package com.shoplocal.repository;

import com.shoplocal.entity.Product;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Date: 01/01/21
 *
 * @author Sagar Jain
 */
@Configuration
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

  @Query("SELECT P FROM Product P WHERE LOWER(P.shop.id) = LOWER(:shop_id)")
  List<Product> retrieveByShopId(@Param("shop_id") String shopId);

}
