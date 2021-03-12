package com.shoplocal.service;

import com.shoplocal.dto.application.ShopDTO;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.entity.Shop;

import java.util.List;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
public interface ShopService {

  ShopDTO createNewShop(Shop Shop);

  ShopDTO updateShop(Shop Shop);

  Status deleteShop(String id);

  ShopDTO findShop(String id);

  List<ShopDTO> findNearbyShops(Double latitude, Double longitude, String pinCode);

  Boolean isShopServiceable(String id, Double latitude, Double longitude);
}
