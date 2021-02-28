package com.shoplocal.helper.converter.mapper;

import com.shoplocal.dto.application.ShopDTO;
import com.shoplocal.entity.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
@Component
public class ShopConverter implements IEntityConverter<ShopDTO, Shop> {

  @Autowired private ModelMapper modelMapper;

  @Override
  public Shop map(ShopDTO source) {
    return modelMapper.map(source, Shop.class);
  }

  @Override
  public ShopDTO map(Shop target) {
    return modelMapper.map(target, ShopDTO.class);
  }
}
