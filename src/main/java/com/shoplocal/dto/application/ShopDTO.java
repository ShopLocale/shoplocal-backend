package com.shoplocal.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
@Data
@ApiModel(value = "ShopDTO")
public class ShopDTO extends BaseDTO {

  @JsonProperty("shopId")
  @ApiModelProperty(value = "shopId")
  private UUID id;

  private String shopName;

  private String shortenedShopUri;

  private SellerDTO seller;

  private AddressDTO address;

  private Boolean active;

  private String image;

  private String category;

  private String serviceType;

  private Double distance;

  private Double deliveryCharge;
}
