package com.shoplocal.service;

import com.shoplocal.dto.application.ProductDTO;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.entity.Product;

import java.util.List;

/**
 * Date: 01/01/21
 *
 * @author Sagar Jain
 */
public interface ProductService {

	ProductDTO createNewProduct(Product product);

	ProductDTO findProduct(String id);

	ProductDTO updateProduct(Product product);

	List<ProductDTO> findProductByShopId(String shopId);

	Status deleteProduct(String id);

//	List<Product> findProductByName(String name);
//
//	List<Product> findProductByNameLike(String nameLike);
//
//	// This can happen in UI too
//	List<Product> findProductByNameLikeWithinShop(String nameLike, Shop shop);


}
