package com.shoplocal.service.impl;

import com.shoplocal.dto.application.OrderDTO;
import com.shoplocal.dto.constant.OrderState;
import com.shoplocal.entity.Order;
import com.shoplocal.repository.*;
import com.shoplocal.service.OrderService;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    /* ---------------- Fields ---------------- */
    private static final Logger log = LogManager.getLogger();
    
    @Autowired private OrderRepository orderRepository;

    @Autowired private ShopRepository shopRepository;

    @Autowired private CustomerRepository customerRepository;

    @Autowired private AddressRepository addressRepository;

    @Autowired private OrderItemRepository orderItemRepository;

    @Autowired
    private IEntityConverter<OrderDTO, Order> orderConverter;

    @Override
    public OrderDTO createNewOrder(Order order) {
        log.info("Add new Order: {}", order);

        order.setShop(shopRepository.getOne(order.getShop().getId()));
        order.setCustomer(customerRepository.getOne(order.getCustomer().getId()));
        order.setAddress(addressRepository.getOne(order.getAddress().getId()));

        order.getOrderItems().forEach(orderItem -> {
            orderItem.setOrder(order);
        });
        order.setOrderState(OrderState.Created);
        return orderConverter.map(orderRepository.save(order));
    }

    @Override
    public OrderDTO findOrder(@NotNull String id) {
        log.info("Find Order whose id is: {}", id);
        return orderConverter.map(orderRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NoSuchElementException("Order with ID " + id + " not found")));
    }

    @Override
    public OrderDTO updateOrder(Order order) {
        log.info("Update Order: {}", order);
        order.setShop(shopRepository.getOne(order.getShop().getId()));
        order.setCustomer(customerRepository.getOne(order.getCustomer().getId()));
        order.setAddress(addressRepository.getOne(order.getAddress().getId()));

        order.getOrderItems().forEach(orderItem -> {
            orderItem.setOrder(order);
        });
        return orderConverter.map(orderRepository.save(order));
    }

    @Override
    public Status deleteOrder(String id) {
        log.info("Delete Order "+ id);
        try {
            orderRepository.deleteById(UUID.fromString(id));
        } catch (Exception ex) {
            throw new NoSuchElementException("Order with ID " + id + " not present in DB");
        }
        return Status.SUCCESS;
    }

    public List<OrderDTO> findOrderByShopId(String shopId) {
        log.info("Find all orders associated with shop Id: {}", shopId);
        return orderRepository.findByShopId(shopId).stream()
                .map(element -> orderConverter.map(element)).collect(
                        Collectors.toList());
    }

    public List<OrderDTO> findOrderByCustomerId(String customerId) {
        log.info("Find all orders associated with customerId: {}", customerId);
        return orderRepository.findByCustomerId(customerId).stream()
                .map(element -> orderConverter.map(element)).collect(
                        Collectors.toList());
    }
}
