package com.shoplocal.repository;

import java.util.HashSet;
import java.util.Set;

import com.shoplocal.entity.Address;
import com.shoplocal.entity.Category;
import com.shoplocal.entity.Seller;
import com.shoplocal.entity.Shop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Date: 12/29/2020
 *
 * @author Sagar Jain
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@EnableJpaAuditing
public class SellerRepositoryTest {

  @Autowired private TestEntityManager testEntityManager;

  @Autowired private SellerRepository sellerRepository;

  @Autowired private AddressRepository addressRepository;

  @Autowired private ShopRepository shopRepository;

  /* ---------------- Test cases ---------------- */

  @Test
  public void whenFindBySellerName_thenReturnSeller() {

    Seller seller = new Seller();
    Address address = new Address();
    Category shopCategory = new Category();
    Shop shop = new Shop();
    // shopCategory.setType("Electronics");

    address.setAddressLine1("line1");
    address.setAddressLine2("line2");
    address.setCity("kucah");
    address.setState("Raj");
    address.setMobileNumber("8754547074");
    address.setName("Sagar's house");
    address.setLandmark("Opposite to Airport");
    address.setPinCode("600097");

    /*    shop.setContactNumber("8754547074");
    shop.setName("A B C Enterprise");
    shop.setUniqueName("abcenterprise1");
    shop.setActive(Boolean.TRUE);
    shop.setSeller(seller);*/
    // shop.setShopCategory(shopCategory);
    // shop.setImage("img://");
    shop.setServiceType("Delivery");
    shop.setAddress(address);

    Set<Shop> shopSet = new HashSet<>();
    shopSet.add(shop);
    // seller.setShop(shopSet);
    seller.setFirstName("Sagar");
    seller.setLastName("Jain");
    // seller.setContactNumber("8754547074");

    // Save this in mock DB
    /* testEntityManager.persist(state);
    testEntityManager.persist(address);
    testEntityManager.persist(seller);

    Seller probe = new Seller();
    Shop shopProbe = new Shop();
    Set<Shop> shopSet1 = new HashSet<>();
    shopSet1.add(shopProbe);*/
    // shopProbe.setUniqueName("abcenterprise1");
    //// probe.setShop(shopSet1);

    // Seller fetchedSeller = sellerRepository.findOne(Example.of(probe)).get();
    // assertThat(fetchedSeller.getShop().contains(shop));

    // Shop fetchedShop = shopRepository.findOne(Example.of(shopProbe)).get();
    // assertThat(fetchedShop.getSeller().getId()).isEqualTo(fetchedSeller.getId());
  }
}
