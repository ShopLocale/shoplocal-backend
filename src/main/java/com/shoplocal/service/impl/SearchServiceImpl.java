package com.shoplocal.service.impl;

import com.shoplocal.dto.application.ProductDTO;
import com.shoplocal.dto.application.SearchResultDTO;
import com.shoplocal.dto.application.ShopDTO;
import com.shoplocal.entity.Product;
import com.shoplocal.entity.Shop;
import com.shoplocal.helper.converter.mapper.IEntityConverter;

import org.hibernate.search.mapper.orm.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl{

    @Autowired
    private IEntityConverter<ProductDTO, Product> productConverter;

    @Autowired
    private IEntityConverter<ShopDTO, Shop> shopConverter;

    @PersistenceContext
    private EntityManager entityManager;

    public SearchResultDTO search(String searchString, int limit){
        SearchResultDTO searchResultDTO = new SearchResultDTO();

        List<Product> productList = getMatchingProductList(searchString, limit);
        Set<Product> productSet = new HashSet<>(productList);

        Set<ProductDTO> productDTOSet = productSet
                .stream()
                .map(product -> productConverter.map(product))
                .collect(Collectors.toSet());

        List<Shop> shopList = getMatchingShopList(searchString, limit);
        Set<Shop> shopSet = new HashSet<>(shopList);
        Set<ShopDTO> shopDTOSet = shopSet
                .stream()
                .map(shop -> shopConverter.map(shop))
                .collect(Collectors.toSet());

        searchResultDTO.setProducts(productDTOSet);
        searchResultDTO.setShops(shopDTOSet);
        return searchResultDTO;
    }

    private List<Product> getMatchingProductList(String searchString, int limit){
        List<Product> productList = Search.session(entityManager).search(Product.class)
                .where(f -> f.match()
                        .fields("name", "description")
                        .matching(searchString))
                .fetchHits(0, limit);

        return productList;
    }

    private List<Shop> getMatchingShopList(String searchString, int limit){
        List<Shop> shopList = Search.session(entityManager).search(Shop.class)
                .where(f -> f.match()
                        .fields("shopName", "shortenedShopUri", "category")
                        .matching(searchString))
                .fetchHits(0, limit);
        return shopList;
    }
}
