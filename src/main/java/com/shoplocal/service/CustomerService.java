package com.shoplocal.service;

import com.shoplocal.dto.constant.Status;
import com.shoplocal.dto.application.CustomerDTO;
import com.shoplocal.entity.Address;
import com.shoplocal.entity.Customer;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
public interface CustomerService {

  CustomerDTO createNewCustomer(Customer customer);

  CustomerDTO updateCustomer(Customer customer);

  Status deleteCustomer(String id);

  CustomerDTO findCustomer(String id);

  CustomerDTO addAddress(String id, Address address);
}
