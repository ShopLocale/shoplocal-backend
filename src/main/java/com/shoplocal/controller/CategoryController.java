package com.shoplocal.controller;

import com.shoplocal.dto.application.CategoryDTO;
import com.shoplocal.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 01/01/2021
 *
 * @author Kushal Roy
 */
@RestController
@RequestMapping(path = "category-management/v1")
@Api(tags = "Category management api")
public class CategoryController {

  /* ---------------- Fields ---------------- */

  @Autowired private CategoryService categoryService;

  /* ---------------- Public api ---------------- */

  @ApiOperation(
      value = "Get all categories.",
      notes = "Get a list of ordered category list",
      responseContainer = "List",
      response = CategoryDTO.class,
      produces = "application/json")
  @GetMapping(value = "/category/", produces = "application/json")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(categoryService.getAllCategories());
  }
}
