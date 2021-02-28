package com.shoplocal.helper.converter.mapper;

import com.shoplocal.dto.application.CategoryDTO;
import com.shoplocal.entity.Category;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@Component
public class CategoryConverter implements IEntityConverter<CategoryDTO, Category> {

  private static final Logger log = LoggerFactory.getLogger(SellerConverter.class);

  @Autowired private ModelMapper modelMapper;

  @Override
  public Category map(CategoryDTO source) {
    log.info("Converting Product Category DTO to entity {}", source.toString());

    return modelMapper.map(source, Category.class);
  }

  @Override
  public CategoryDTO map(Category target) {
    return modelMapper.map(target, CategoryDTO.class);
  }
}
