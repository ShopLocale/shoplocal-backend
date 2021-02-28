package com.shoplocal.service;

import com.shoplocal.dto.constant.Status;
import com.shoplocal.dto.application.SellerDTO;
import com.shoplocal.entity.Seller;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
public interface SellerService {

  SellerDTO createNewSeller(Seller seller);

  SellerDTO findSellerById(String id);

  SellerDTO updateSeller(Seller seller);

  Status deleteSeller(String id);
}
