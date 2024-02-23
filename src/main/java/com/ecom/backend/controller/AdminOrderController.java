package com.ecom.backend.controller;

import com.ecom.backend.dao.response.ApiResponse;
import com.ecom.backend.exception.OrderException;
import com.ecom.backend.model.Order;
import com.ecom.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/order")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrdersHandler() {
        List<Order> orders = orderService.getAllOrder();
        return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> confirmOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {
        Order order = orderService.confirmOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/ship")
    public ResponseEntity<Order> shipOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {
        Order order = orderService.shippedOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/deliver")
    public ResponseEntity<Order> deliverOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {
        Order order = orderService.deliveredOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {
        Order order = orderService.canceledOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}/delete")
    public ResponseEntity<ApiResponse> deleteOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {
        orderService.deleteOrder(orderId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Order deleted successfully");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
