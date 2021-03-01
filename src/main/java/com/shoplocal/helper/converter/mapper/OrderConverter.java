package com.shoplocal.helper.converter.mapper;

import com.shoplocal.dto.application.OrderDTO;
import com.shoplocal.dto.application.OrderItemDTO;
import com.shoplocal.entity.Order;
import com.shoplocal.entity.OrderItem;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Date: 22/02/2021
 *
 * @author Sagar Jain
 */
@Component
public class OrderConverter implements IEntityConverter<OrderDTO, Order> {

    @Autowired private ModelMapper modelMapper;

    @Autowired private IEntityConverter<OrderItemDTO, OrderItem> orderItemConverter;


    @Override
    public Order map(OrderDTO source) {
        List<OrderItem> orderItems = source.getOrderItems()
                .stream()
                .map(orderItemDTO -> orderItemConverter.map(orderItemDTO))
                .collect(Collectors.toList());

        Order order = modelMapper.map(source, Order.class);
        order.setOrderItems(orderItems);
        return order;
    }

    @Override
    public OrderDTO map(Order target) {
        List<OrderItemDTO> orderItemDTOS = target.getOrderItems()
                .stream()
                .map(orderItem -> orderItemConverter.map(orderItem))
                .collect(Collectors.toList());

        OrderDTO orderDTO = modelMapper.map(target, OrderDTO.class);
        orderDTO.setOrderItems(orderItemDTOS);
        return orderDTO;
    }
}
