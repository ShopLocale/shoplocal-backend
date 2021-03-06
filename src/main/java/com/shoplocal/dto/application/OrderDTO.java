package com.shoplocal.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoplocal.dto.constant.OrderState;
import com.shoplocal.dto.minimal.AddressMinimalDTO;
import com.shoplocal.dto.minimal.CustomerMinimalDTO;

import com.shoplocal.dto.minimal.ShopMinimalDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
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

    private ShopDTO shop;

    private CustomerMinimalDTO customer;

    private String orderType;

    private AddressDTO address;

    private Double totalAmount;

    private Double discountAmount;

    private Double deliveryCharge;

    private Double payableAmount;

    private List<OrderItemDTO> orderItems = new ArrayList<>();

    private OrderState orderState;

}
