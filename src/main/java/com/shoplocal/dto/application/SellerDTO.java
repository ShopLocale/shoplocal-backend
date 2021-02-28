package com.shoplocal.dto.application;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

/**
 * Date: 25/02/2021
 *
 * @author Sagar Jain
 */
@Data
@ApiModel(value = "SellerDTO")
public class SellerDTO extends BaseDTO {

    @JsonProperty("sellerId")
    @ApiModelProperty(value = "sellerId")
    private UUID id;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String email;

    private Boolean active;

}

