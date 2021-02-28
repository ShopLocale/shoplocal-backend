package com.shoplocal.helper.converter.mapper;

import com.shoplocal.dto.application.OrderItemDTO;
import com.shoplocal.dto.application.ProductDTO;
import com.shoplocal.entity.OrderItem;
import org.springframework.stereotype.Component;

/**
 * Date: 22/02/2021
 *
 * @author Sagar Jain
 */
@Component
public class OrderItemConverter implements IEntityConverter<OrderItemDTO, OrderItem> {

    @Override
    public OrderItem map(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setName(orderItemDTO.getProduct().getName());
        orderItem.setPrice(orderItemDTO.getProduct().getPrice());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        return orderItem;
    }

    @Override
    public OrderItemDTO map(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(orderItem.getName());
        productDTO.setPrice(orderItem.getPrice());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setProduct(productDTO);
        return orderItemDTO;
    }
}
