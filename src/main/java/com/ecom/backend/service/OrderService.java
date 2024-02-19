package com.ecom.backend.service;

import com.ecom.backend.exception.OrderException;
import com.ecom.backend.model.Address;
import com.ecom.backend.model.Order;
import com.ecom.backend.model.User;

import java.util.List;

public interface OrderService {
    public Order createOrder(User user, Address shippingAddress);
    public Order findOrderById(Long orderId) throws OrderException;
    public List<Order> userOrderHistory(Long userId);
    public Order placedOrder(Long orderId) throws OrderException;
    public Order confirmOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order canceledOrder(Long orderId) throws OrderException;
    public List<Order> getAllOrder();
    public void deleteOrder(Long orderId) throws OrderException;
}
