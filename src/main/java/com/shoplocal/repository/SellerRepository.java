package com.shoplocal.repository;

import com.shoplocal.entity.Seller;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
@Repository
public interface SellerRepository extends JpaRepository<Seller, UUID> {}
