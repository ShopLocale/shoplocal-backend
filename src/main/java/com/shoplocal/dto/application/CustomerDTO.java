package com.shoplocal.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import lombok.Data;

/**
 * Date: 25/02/2021
 *
 * @author Sagar Jain
 */
@Data
@ApiModel(value = "CustomerDTO")
public class CustomerDTO extends BaseDTO{

  @JsonProperty("customerId")
  @ApiModelProperty(value = "customerId")
  private UUID id;

  private String firstName;

  private String lastName;

  private String mobileNumber;

  private String email;

  private Boolean active;

//  @JsonIgnoreProperties
  private Set<AddressDTO> addresses = new HashSet<>();
}
