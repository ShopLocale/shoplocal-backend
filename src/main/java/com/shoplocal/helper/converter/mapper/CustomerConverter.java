package com.shoplocal.helper.converter.mapper;

import com.shoplocal.dto.application.CustomerDTO;
import com.shoplocal.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@Component
public class CustomerConverter implements IEntityConverter<CustomerDTO, Customer> {

  @Autowired private ModelMapper modelMapper;

  @Override
  public Customer map(CustomerDTO source) {
    return modelMapper.map(source, Customer.class);
  }

  @Override
  public CustomerDTO map(Customer target) {
    return modelMapper.map(target, CustomerDTO.class);
  }
}
