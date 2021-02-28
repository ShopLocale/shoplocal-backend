package com.shoplocal.service.impl;

import com.shoplocal.repository.ProductRepository;
import com.shoplocal.repository.ShopRepository;
import com.shoplocal.dto.application.ProductDTO;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.entity.Product;
import com.shoplocal.entity.Shop;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.service.ProductService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date: 02/01/21
 *
 * @author Sagar Jain
 */
@Service
public class ProductServiceImpl implements ProductService {

  /* ---------------- Fields ---------------- */
  private static final Logger log = LogManager.getLogger();

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private ShopRepository shopRepository;

  @Autowired
  private IEntityConverter<ProductDTO, Product> productConverter;
  /* ---------------- Methods ---------------- */

  @Override
  public ProductDTO createNewProduct(Product product) {
    log.info("Add new Product", product);
    product.setShop(shopRepository.getOne(product.getShop().getId()));
    return productConverter.map(productRepository.save(product));
  }

  @Override
  public ProductDTO findProduct(@NotNull String id) {
    log.info("Find Product whose id is : {}", id);
    return productConverter.map(productRepository.findById(UUID.fromString(id))
        .orElseThrow(() -> new NoSuchElementException("Product with ID " + id + " not found")));
  }

  @Override
  public ProductDTO updateProduct(Product product) {
    log.info("Update Product ", product);
    Optional<Product> productOptional = productRepository.findById(product.getId());

		if (!productOptional.isPresent()) {
			throw new NoSuchElementException("Product with ID " + product.getId() + " not present in DB");
		}
    product.setShop(shopRepository.getOne(product.getShop().getId()));
    return productConverter.map(productRepository.save(product));
  }

  @Override
  public Status deleteProduct(String id) {
    log.info("Delete Product ", id);
    try {
      productRepository.deleteById(UUID.fromString(id));
    } catch (Exception ex) {
      throw new NoSuchElementException("Product with ID " + id + " not present in DB");
    }
    return Status.SUCCESS;
  }

  public List<ProductDTO> findProductByShopId(String shopId) {
    log.info("Find all product associated with shop Id:", shopId);
    Product probe = new Product();
    Shop shopProbe = new Shop();
    shopProbe.setId(UUID.fromString(shopId));
    probe.setShop(shopProbe);
    return productRepository.retrieveByShopId(shopId).stream()
        .map(element -> productConverter.map(element)).collect(
            Collectors.toList());
  }
}
