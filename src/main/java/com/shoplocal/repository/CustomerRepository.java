package com.shoplocal.repository;

import com.shoplocal.entity.Customer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {}
