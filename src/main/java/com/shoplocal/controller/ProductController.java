package com.shoplocal.controller;

import com.shoplocal.dto.application.ProductDTO;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.entity.Product;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Date: 01/01/21
 *
 * @author Sagar Jain
 */
@RestController
@RequestMapping(path = "product-management/v1")
@Api(tags = "Product management api")
public class ProductController {

	/* ---------------- Fields ---------------- */

	@Autowired
	private ProductService productService;

	@Autowired
	private IEntityConverter<ProductDTO, Product> productConverter;


	/* ---------------- Public api ---------------- */

	@ApiOperation(
			value = "Get product.",
			notes = "Gets product with the given ID.",
			response = ProductDTO.class,
			produces = "application/json",
			consumes = "application/json",
			tags = "Product")
	@GetMapping(
			value = "/product/{id}",
			produces = "application/json")
	public ResponseEntity<?> findProductById(
			@ApiParam(value = "Product id") @PathVariable(value = "id", required = false) String id) {
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(productService.findProduct(id));
	}

	@ApiOperation(
			value = "Create product.",
			notes = "Creates product record in database",
			response = ProductDTO.class,
			produces = "application/json",
			consumes = "application/json",
			tags = "Product")
	@PostMapping(
			value = "/product",
			produces = "application/json")
	public ResponseEntity<?> createProduct(
			@ApiParam(value = "productDTO") @RequestBody() ProductDTO productDTO) {
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(productService.createNewProduct(productConverter.map(productDTO)));
	}

	@ApiOperation(
			value = "Update a product.",
			notes = "Updates a product in the database",
			response = ProductDTO.class,
			produces = "application/json",
			consumes = "application/json")
	@PutMapping(
			value = "/product",
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<?> update(@RequestBody ProductDTO productDTO) {
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(productService.updateProduct(productConverter.map(productDTO)));
	}

	@ApiOperation(
			value = "Delete Product",
			notes = "Delete a product by ID",
			response = Status.class,
			produces = "application/json",
			consumes = "text/plain")
	@DeleteMapping(value = "/product/{id}", produces = "application/json")
	public ResponseEntity<?> delete(
			@ApiParam(value = "ID of the product") @PathVariable(value = "id") String id) {
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(productService.deleteProduct(id));
	}

	/* ---------------- Public api ---------------- */

	@ApiOperation(
			value = "Get all products for a shop.",
			notes = "Gets product with the given ShopID.",
			response = ProductDTO.class,
			responseContainer = "List",
			produces = "application/json",
			consumes = "application/json",
			tags = "Product")
	@GetMapping(
			value = "/product/shop/{shopId}",
			produces = "application/json")
	public ResponseEntity<?> findProductByShopId(
			@ApiParam(value = "Shop id") @PathVariable(value = "shopId") String shopId) {
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(productService.findProductByShopId(shopId));
	}
}