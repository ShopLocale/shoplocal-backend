package com.shoplocal.service.impl;

import com.shoplocal.helper.location.DistanceHelper;
import com.shoplocal.repository.ProductCategoryRepository;
import com.shoplocal.repository.SellerRepository;
import com.shoplocal.repository.ShopRepository;
import org.apache.commons.lang3.StringUtils;
import com.shoplocal.dto.application.ShopDTO;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.entity.Shop;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.helper.location.Point;
import com.shoplocal.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
@Service
public class ShopServiceImpl implements ShopService {

  /* ---------------- Fields ---------------- */

  private static final Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

  @Autowired private ShopRepository shopRepository;

  @Autowired private SellerRepository sellerRepository;

  @Autowired private ProductCategoryRepository productCategoryRepository;

  @Autowired private IEntityConverter<ShopDTO, Shop> shopConverter;


  /* ---------------- Methods ---------------- */

  @Override
  public ShopDTO createNewShop(Shop shop) {
    log.info("Add new Shop {}", shop);

    if(shop.getSeller().getId()!=null){
      shop.setSeller(sellerRepository.getOne(shop.getSeller().getId()));
    }else{
      shop.setSeller(sellerRepository.save(shop.getSeller()));
    }
    return shopConverter.map(shopRepository.save(shop));
  }

  @Override
  public ShopDTO updateShop(Shop shop) {
    log.info("Add new Shop {}", shop);
    shop.setSeller(sellerRepository.getOne(shop.getSeller().getId()));
    return shopConverter.map(shopRepository.save(shop));
  }

  @Override
  public Status deleteShop(String id) {
    log.info("Trying to delete shop with ID {}", id);
    try {
      shopRepository.deleteById(UUID.fromString(id));
    } catch (Exception ex) {
      throw new NoSuchElementException("Shop with ID " + id + " not present in DB");
    }
    return Status.SUCCESS;
  }

  @Override
  public ShopDTO findShop(String id) {
    log.info("Find Shop whose id is : {}", id);
    return shopConverter.map(shopRepository
            .findById(UUID.fromString(id))
            .orElseThrow(() -> new NoSuchElementException("Shop with ID " + id + " not found")));
  }

  @Override
  public List<ShopDTO> findNearbyShops(String latitude, String longitude, String pinCode) {
    log.info("Find Shop in pincode : {}", pinCode);
    List<Shop> shopList;
    if (StringUtils.isBlank(pinCode))
      shopList = shopRepository.findAll();
    else
      shopList = shopRepository.findByPin(pinCode);
    DistanceHelper.updateShopList(new Point(Double.parseDouble(latitude), Double.parseDouble(longitude)), shopList, 1);
    return shopList.stream()
            .map(element -> shopConverter.map(element)).collect(
                    Collectors.toList());
  }

}
