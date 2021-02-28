package com.shoplocal.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoplocal.dto.constant.OrderState;
import com.shoplocal.dto.minimal.AddressMinimalDTO;
import com.shoplocal.dto.minimal.CustomerMinimalDTO;

import com.shoplocal.dto.minimal.ShopMinimalDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@ApiModel(value = "OrderDTO")
public class OrderDTO extends BaseDTO {
    @JsonProperty("orderId")
    @ApiModelProperty(value = "orderId")
    private UUID id;

    private ShopMinimalDTO shop;

    private CustomerMinimalDTO customer;

    private String orderType;

    private AddressMinimalDTO address;

    private Double totalAmount;

    private Double discountAmount;

    private Double deliveryCharge;

    private Double payableAmount;

    private Set<OrderItemDTO> orderItems = new HashSet<>();

    private OrderState orderState;

}
