package com.shoplocal.controller;

import com.shoplocal.dto.application.OrderDTO;
import com.shoplocal.entity.Order;
import com.shoplocal.dto.constant.Status;
import com.shoplocal.helper.converter.mapper.IEntityConverter;
import com.shoplocal.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "order-management/v1")
@Api(tags = "Order Management api")
public class OrderController {

    @Autowired private OrderService orderService;

    @Autowired private IEntityConverter<OrderDTO, Order> orderConverter;

    @ApiOperation(
            value = "Create order.",
            notes = "Creates order record in db",
            response = OrderDTO.class,
            produces = "application/json",
            consumes = "application/json",
            tags = "Order")
    @PostMapping(
            value = "/order",
            produces = "application/json"
    )
    public ResponseEntity<?> create(
            @ApiParam(value = "orderDTO") @RequestBody OrderDTO orderDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.createNewOrder(orderConverter.map(orderDTO)));
    }


    @ApiOperation(
            value = "Get order.",
            notes = "Gets order with the given orderId.",
            response = OrderDTO.class,
            produces = "application/json",
            consumes = "application/json",
            tags = "Order")
    @GetMapping(
            value = "/order/{id}",
            produces = "application/json")
    public ResponseEntity<?> findOrderById(
            @ApiParam(value = "Order id") @PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.findOrder(id));
    }

    @ApiOperation(
            value = "Update a order.",
            notes = "Updates a order in the database",
            response = OrderDTO.class,
            produces = "application/json",
            consumes = "application/json")
    @PutMapping(
            value = "/order",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<?> update(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.updateOrder(orderConverter.map(orderDTO)));
    }

    @ApiOperation(
            value = "Delete Order",
            notes = "Deletes an order by ID",
            response = Status.class,
            produces = "application/json",
            consumes = "text/plain")
    @DeleteMapping(value = "/order/{id}", produces = "application/json")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Order id") @PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.deleteOrder(id));
    }

    @ApiOperation(
            value = "Get all order for a shop.",
            notes = "Gets order with the given ShopID.",
            response = OrderDTO.class,
            responseContainer = "List",
            produces = "application/json",
            consumes = "application/json",
            tags = "Order")
    @GetMapping(
            value = "/order/shop/{shopId}",
            produces = "application/json")
    public ResponseEntity<?> findOrderByShopId(
            @ApiParam(value = "Shop id") @PathVariable(value = "shopId") String shopId) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.findOrderByShopId(shopId));
    }

    @ApiOperation(
            value = "Get all order for a customer.",
            notes = "Gets order with the given CustomerId.",
            response = OrderDTO.class,
            responseContainer = "List",
            produces = "application/json",
            consumes = "application/json",
            tags = "Order")
    @GetMapping(
            value = "/order/customer/{customerId}",
            produces = "application/json")
    public ResponseEntity<?> findOrderByCustomerId(
            @ApiParam(value = "Customer id") @PathVariable(value = "customerId") String customerId) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.findOrderByCustomerId(customerId));
    }

}
