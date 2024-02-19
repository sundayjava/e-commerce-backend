package com.ecom.backend.service;

import com.ecom.backend.exception.CartItemException;
import com.ecom.backend.exception.UserException;
import com.ecom.backend.model.Cart;
import com.ecom.backend.model.CartItem;
import com.ecom.backend.model.Product;

public interface CartItemService {
    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

    public CartItem isCardItemExist(Cart cart, Product product, String size, Long userId);

    public void removeCardItem(Long userId, Long cartItemId) throws CartItemException, UserException;

    public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
