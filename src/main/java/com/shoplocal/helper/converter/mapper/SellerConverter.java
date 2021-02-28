package com.shoplocal.helper.converter.mapper;

import com.shoplocal.dto.application.SellerDTO;
import com.shoplocal.entity.Seller;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
@Component
public class SellerConverter implements IEntityConverter<SellerDTO, Seller> {

  private static final Logger log = LoggerFactory.getLogger(SellerConverter.class);

  @Autowired private ModelMapper modelMapper;

  @Override
  public Seller map(SellerDTO source) {
    return modelMapper.map(source, Seller.class);
  }

  @Override
  public SellerDTO map(Seller target) {
    return modelMapper.map(target, SellerDTO.class);
  }
}
