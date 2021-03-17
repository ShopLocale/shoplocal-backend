package com.shoplocal.controller;

import com.shoplocal.dto.application.SearchRequestDTO;
import com.shoplocal.dto.application.SearchResultDTO;
import com.shoplocal.service.impl.SearchServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "search-management/v1")
@Api(tags = "Search management api")
public class SearchController {

    @Autowired
    private SearchServiceImpl searchService;

    @ApiOperation(
            value = "Search for products or shops",
            notes = "Search for products or shops",
            response = SearchResultDTO.class,
            produces = "application/json",
            consumes = "application/json")
    @GetMapping(value = "/search")
    public ResponseEntity<?> search(
            @RequestBody SearchRequestDTO searchRequestDTO) {
                return ResponseEntity.status(HttpStatus.OK)
                .body(searchService.search(searchRequestDTO.getSearchString(), 3));
    }
}
