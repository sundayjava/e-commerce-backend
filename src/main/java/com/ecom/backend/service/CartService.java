package com.ecom.backend.service;

import com.ecom.backend.dao.request.AddItemRequest;
import com.ecom.backend.exception.ProductException;
import com.ecom.backend.model.Cart;
import com.ecom.backend.model.User;

public interface CartService {
    public Cart createCart(User user);
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
    public Cart findUserCart(Long userId);
}
