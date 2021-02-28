package com.shoplocal.controller;

import com.shoplocal.dto.constant.Status;
import com.shoplocal.dto.application.ShopDTO;
import com.shoplocal.entity.Shop;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping(path = "shop-management/v1")
@Api(tags = "Shop management api")
public class ShopController {

  /* ---------------- Fields ---------------- */

  @Autowired private ShopService shopService;

  @Autowired private IEntityConverter<ShopDTO, Shop> shopConverter;

  /* ---------------- Public api ---------------- */

  @ApiOperation(
      value = "Get Shop.",
      notes = "Gets Shop with the given ID.",
      response = ShopDTO.class,
      produces = "application/json",
      consumes = "application/json")
  @GetMapping(value = "/shop/{id}", produces = "application/json")
  public ResponseEntity<?> findShopById(
      @ApiParam(value = "Shop id") @PathVariable(value = "id", required = false) String id) {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(shopConverter.map(shopService.findShop(id)));
  }

  @ApiOperation(
      value = "Create Shop.",
      notes = "Creates Shop record in database",
      response = ShopDTO.class,
      produces = "application/json",
      consumes = "application/json")
  @PostMapping(value = "/shop", produces = "application/json")
  public ResponseEntity<?> create(@RequestBody ShopDTO shop) {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(shopConverter.map(shopService.createNewShop(shopConverter.map(shop))));
  }

  @ApiOperation(
      value = "Update a shop.",
      notes = "Updates a shop to the application",
      response = ShopDTO.class,
      produces = "application/json",
      consumes = "application/json")
  @PutMapping(value = "/shop", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> update(@RequestBody ShopDTO shop) {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(shopConverter.map(shopService.updateShop(shopConverter.map(shop))));
  }

  @ApiOperation(
      value = "Delete Shop",
      notes = "Delete a shop by ID",
      response = Status.class,
      produces = "application/json",
      consumes = "text/plain")
  @DeleteMapping(value = "/shop/{id}", produces = "application/json")
  public ResponseEntity<?> delete(
      @ApiParam(value = "ID of the shop") @PathVariable(value = "id") String id) {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(shopService.deleteShop(id));
  }

  @ApiOperation(
          value = "Get Nearby Shops.",
          notes = "Gets Nearby Shops with given lat and long.",
          responseContainer = "List",
          response = ShopDTO.class,
          produces = "application/json",
          consumes = "application/json")
  @GetMapping(value = "/shop/", produces = "application/json")
  public ResponseEntity<?> findNearbyShop(@RequestParam("latitude") String latitude,
                                          @RequestParam("longitude") String longitude,
                                          @RequestParam(value = "pinCode", required = false) String pinCode) {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(shopService.findNearbyShops(latitude, longitude, pinCode));
  }
}
