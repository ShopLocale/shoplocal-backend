package com.shoplocal.service;

import com.shoplocal.dto.application.OrderDTO;
import com.shoplocal.entity.Order;
import com.shoplocal.dto.constant.Status;

import java.util.List;

/**
 * Date: 22/02/2021
 *
 * @author Sagar Jain
 */
public interface OrderService {

    OrderDTO createNewOrder(Order Order);

    OrderDTO updateOrder(Order Order);

    Status deleteOrder(String id);

    OrderDTO findOrder(String id);

    List<OrderDTO> findOrderByShopId(String shopId);

    List<OrderDTO> findOrderByCustomerId(String customerId);
}
