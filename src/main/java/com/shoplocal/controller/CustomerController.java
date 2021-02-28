package com.shoplocal.controller;

import com.shoplocal.dto.application.AddressDTO;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.dto.application.CustomerDTO;
import com.shoplocal.entity.Address;
import com.shoplocal.entity.Customer;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@RestController
@RequestMapping(path = "customer-management/v1")
@Api(tags = "Customer management api")
public class CustomerController {

  /* ---------------- Fields ---------------- */

  @Autowired private CustomerService customerService;

  @Autowired private IEntityConverter<CustomerDTO, Customer> customerConverter;

  @Autowired private IEntityConverter<AddressDTO, Address> addressConverter;

  /* ---------------- Public api ---------------- */

  @ApiOperation(
      value = "Add a customer.",
      notes = "Creates new customer to the application",
      response = CustomerDTO.class,
      produces = "application/json",
      consumes = "application/json")
  @PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> create(@RequestBody CustomerDTO customer) {

    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(customerService.createNewCustomer(customerConverter.map(customer)));
  }

  @ApiOperation(
      value = "Update a customer.",
      notes = "Updates a customer to the application",
      response = CustomerDTO.class,
      produces = "application/json",
      consumes = "application/json")
  @PutMapping(value = "/customer", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> update(@RequestBody CustomerDTO customer) {

    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(customerService.updateCustomer(customerConverter.map(customer)));
  }

  @ApiOperation(
      value = "Delete customer",
      notes = "Delete a customer by ID",
      response = Status.class,
      produces = "application/json",
      consumes = "text/plain")
  @DeleteMapping(value = "/customer/{id}", produces = "application/json")
  public ResponseEntity<?> delete(
      @ApiParam(value = "ID of the customer") @PathVariable(value = "id") String id) {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(customerService.deleteCustomer(id));
  }

  @ApiOperation(
      value = "Find a customer.",
      notes = "Finds customer with the given ID.",
      responseContainer = "List",
      response = CustomerDTO.class,
      produces = "application/json",
      consumes = "application/json")
  @GetMapping(value = "/customer/{id}", produces = "application/json")
  public ResponseEntity<?> get(
      @ApiParam(value = "ID of the customer") @PathVariable(value = "id") String id) {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(customerService.findCustomer(id));
  }

  @ApiOperation(
          value = "Add address for customer",
          notes = "Add address for customer",
          responseContainer = "List",
          response = CustomerDTO.class,
          produces = "application/json",
          consumes = "application/json")
  @PostMapping(value = "/customer/{id}/address", produces = "application/json")
  public ResponseEntity<?> addAddress(
          @ApiParam(value = "ID of the customer") @PathVariable(value = "id") String id,
          @RequestBody AddressDTO addressDTO) {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(customerService.addAddress(id,addressConverter.map(addressDTO)));
  }
}
