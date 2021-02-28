package com.shoplocal.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import lombok.Data;

/**
 * Date: 12/27/2020
 *
 * @author Kushal Roy
 */
@Data
@ApiModel(value = "AddressDTO")
public class AddressDTO extends BaseDTO {

  @JsonProperty("addressId")
  @ApiModelProperty(value = "addressId")
  private UUID id;

  private String name;

  private String mobileNumber;

  private String pinCode;

  private String addressLine1;

  private String addressLine2;

  private String landmark;

  private String addressType;

  private String state;

  private String city;

  private String latitude;

  private String longitude;

}
