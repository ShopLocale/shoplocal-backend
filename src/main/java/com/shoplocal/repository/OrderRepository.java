package com.shoplocal.repository;

import com.shoplocal.entity.Order;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Date: 22/02/2021
 *
 * @author Sagar Jain
 */
@Configuration
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT O FROM Order O WHERE LOWER(O.shop.id) = LOWER(:shop_id)")
    List<Order> findByShopId(@Param("shop_id") String shopId);

    @Query("SELECT O FROM Order O WHERE LOWER(O.customer.id) = LOWER(:customer_id)")
    List<Order> findByCustomerId(@Param("customer_id") String customer_id);

}
