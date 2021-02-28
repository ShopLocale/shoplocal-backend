package com.shoplocal.repository;

import com.shoplocal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Date: 01/01/21
 *
 * @author Kushal Roy
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {}
