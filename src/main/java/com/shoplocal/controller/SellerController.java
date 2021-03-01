package com.shoplocal.controller;

import com.shoplocal.dto.constant.Status;
import com.shoplocal.dto.application.SellerDTO;
import com.shoplocal.entity.Seller;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.service.SellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
@RestController
@RequestMapping(path = "seller-management/v1")
@Api(tags = "Seller management api")
public class SellerController {

  /* ---------------- Fields ---------------- */

  private static final Logger log = LoggerFactory.getLogger(SellerController.class);

  @Autowired private SellerService sellerService;

  @Autowired private IEntityConverter<SellerDTO, Seller> sellerConverter;

  /* ---------------- Public api ---------------- */

  @ApiOperation(
      value = "Get seller.",
      notes = "Gets seller with the given ID.",
      response = SellerDTO.class,
      produces = "application/json",
      consumes = "application/json")
  @GetMapping(value = "/seller/{id}", produces = "application/json")
  public ResponseEntity<?> findById(
      @ApiParam(value = "Seller id") @PathVariable(value = "id", required = false) String id) {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(sellerService.findSellerById(id));
  }

  @ApiOperation(
      value = "Create seller.",
      notes = "Creates seller record in database",
      response = SellerDTO.class,
      produces = "application/json",
      consumes = "application/json")
  @PostMapping(value = "/seller", produces = "application/json")
  public ResponseEntity<?> create(@RequestBody SellerDTO seller) {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(sellerService.createNewSeller(sellerConverter.map(seller)));
  }

  @ApiOperation(
      value = "Update a seller.",
      notes = "Updates a seller to the application",
      response = SellerDTO.class,
      produces = "application/json",
      consumes = "application/json")
  @PutMapping(value = "/seller", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> update(@RequestBody SellerDTO seller) {

    log.info(seller.toString());
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(sellerService.updateSeller(sellerConverter.map(seller)));
  }

  @ApiOperation(
      value = "Delete Seller",
      notes = "Delete a seller by ID",
      response = Status.class,
      produces = "application/json",
      consumes = "text/plain")
  @DeleteMapping(value = "/seller/{id}", produces = "application/json")
  public ResponseEntity<?> delete(
      @ApiParam(value = "ID of the seller") @PathVariable(value = "id") String id) {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(sellerService.deleteSeller(id));
  }
}
