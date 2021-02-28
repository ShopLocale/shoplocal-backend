package com.shoplocal.dto.minimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoplocal.dto.application.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.UUID;

/**
 * Date: 25/02/21
 *
 * @author Sagar Jain
 */
@Data
@ApiModel(value = "AddressMinimalDTO")
public class AddressMinimalDTO extends BaseDTO {

    @JsonProperty("addressId")
    @ApiModelProperty(value = "addressId")
    private UUID id;

}
