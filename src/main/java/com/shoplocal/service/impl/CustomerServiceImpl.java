package com.shoplocal.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoplocal.repository.CustomerRepository;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.dto.application.CustomerDTO;
import com.shoplocal.entity.Address;
import com.shoplocal.entity.Customer;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.service.CustomerService;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  /* ---------------- Fields ---------------- */
  private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

  @Autowired ObjectMapper objectMapper;

  @Autowired private CustomerRepository customerRepository;

  @Autowired private IEntityConverter<CustomerDTO, Customer> customerConverter;

  /* ---------------- Methods ---------------- */

  @Override
  public CustomerDTO createNewCustomer(Customer customer) {
    log.info("Add new customer {}", customer);
    return customerConverter.map(customerRepository.save(customer));
  }

  @Override
  public CustomerDTO updateCustomer(Customer customer) {
    log.info("Update customer {}", customer);
    return customerConverter.map(customerRepository.save(customer));
  }

  @Override
  public Status deleteCustomer(String id) {
    try {
      customerRepository.deleteById(UUID.fromString(id));
    } catch (Exception ex) {
      throw new NoSuchElementException("Customer with ID " + id + " not present in DB");
    }

    return Status.SUCCESS;
  }

  @Override
  public CustomerDTO findCustomer(String id) {
    /*    if (StringUtils.isBlank(id)) {
    log.info("Find all customers");
    */
    /*Page<Customer> page = customerRepository
        .findAll(PageRequest.of(0, 10, Sort.by(Direction.ASC,
            "username")));
    return page.toList();*/
    /*
      return customerRepository.findAll(Sort.by(Direction.ASC, "username"));
    }*/

    log.info("Find customer whose id is : {}", id);
    Customer customer =
        customerRepository
            .findById(UUID.fromString(id))
            .orElseThrow(
                () -> new NoSuchElementException("Customer with ID " + id + " not present in DB"));

    return customerConverter.map(customer);
  }

  @Override
  public CustomerDTO addAddress(String id, Address address){
    Customer customer = customerRepository
            .findById(UUID.fromString(id))
            .orElseThrow(
                    () -> new NoSuchElementException("Customer with ID " + id + " not present in DB"));

    customer.getAddresses().add(address);
    return customerConverter.map(customerRepository.save(customer));
  }
}
