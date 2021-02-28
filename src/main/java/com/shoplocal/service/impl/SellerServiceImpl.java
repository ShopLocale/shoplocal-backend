package com.shoplocal.service.impl;

import com.shoplocal.repository.ProductCategoryRepository;
import com.shoplocal.repository.SellerRepository;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.dto.application.SellerDTO;
import com.shoplocal.entity.Seller;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
@Service
public class SellerServiceImpl implements SellerService {

  /* ---------------- Fields ---------------- */

  private static final Logger log = LoggerFactory.getLogger(SellerServiceImpl.class);

  @Autowired private SellerRepository sellerRepository;

  @Autowired private ProductCategoryRepository productCategoryRepository;

  @Autowired private IEntityConverter<SellerDTO, Seller> sellerConverter;

  /* ---------------- Methods ---------------- */

  @Override
  public SellerDTO createNewSeller(Seller seller) {
    return sellerConverter.map(sellerRepository.save(seller));
  }

  @Override
  public SellerDTO findSellerById(String id) {
    log.info("Find seller whose id is : {}", id);
    Seller seller = sellerRepository
            .findById(UUID.fromString(id))
            .orElseThrow(() -> new NoSuchElementException("Seller with ID " + id + " not found"));

    return sellerConverter.map(seller);
  }

  @Override
  public SellerDTO updateSeller(Seller seller) {
    log.info("Updates a seller {}", seller.toString());
    return sellerConverter.map(sellerRepository.save(seller));
  }

  @Override
  public Status deleteSeller(String id) {
    try {
      sellerRepository.deleteById(UUID.fromString(id));
    } catch (Exception ex) {
      throw new NoSuchElementException("Seller with ID " + id + " not present in DB");
    }
    return Status.SUCCESS;
  }
}
