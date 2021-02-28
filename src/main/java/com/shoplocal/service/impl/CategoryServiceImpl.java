package com.shoplocal.service.impl;

import com.shoplocal.repository.CategoryRepository;
import com.shoplocal.dto.application.CategoryDTO;
import com.shoplocal.entity.Category;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Date: 12/31/2020
 *
 * @author Kushal Roy
 */
@Service
public class CategoryServiceImpl implements CategoryService {

  /* ---------------- Fields ---------------- */

  private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

  @Autowired private CategoryRepository categoryRepository;

  @Autowired private IEntityConverter<CategoryDTO, Category> categoryConverter;

  /* ---------------- Methods ---------------- */

  @Cacheable(value = "_cache", key = "#root.methodName")
  @Override
  public List<CategoryDTO> getAllCategories() {
    log.info("Fetch list of all categories");

    return categoryRepository.findAll(Sort.by(Direction.ASC, "type")).parallelStream()
        .map(x -> categoryConverter.map(x))
        .collect(Collectors.toList());
  }
}
