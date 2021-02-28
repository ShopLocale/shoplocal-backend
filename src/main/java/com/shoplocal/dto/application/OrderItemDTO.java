package com.shoplocal.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "OrderItemDTO")
public class OrderItemDTO extends BaseDTO {
    @JsonProperty("orderItemId")
    @ApiModelProperty(value = "orderItemId")
    private UUID id;

    private ProductDTO product;

    private Integer quantity;
}
