package com.shoplocal.service;

import com.shoplocal.dto.application.CategoryDTO;

import java.util.List;

/**
 * Date: 01/01/2021
 *
 * @author Kushal Roy
 */
public interface CategoryService {

  List<CategoryDTO> getAllCategories();
}
