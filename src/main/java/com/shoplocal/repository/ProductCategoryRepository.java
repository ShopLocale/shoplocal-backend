package com.shoplocal.repository;

import com.shoplocal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<Category, UUID> {}
