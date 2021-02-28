package com.shoplocal.repository;

import com.shoplocal.entity.OrderItem;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Date: 22/02/2021
 *
 * @author Sagar Jain
 */
@Configuration
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}
