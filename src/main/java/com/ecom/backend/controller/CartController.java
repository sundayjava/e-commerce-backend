package com.ecom.backend.controller;

import com.ecom.backend.dao.request.AddItemRequest;
import com.ecom.backend.dao.response.ApiResponse;
import com.ecom.backend.exception.ProductException;
import com.ecom.backend.exception.UserException;
import com.ecom.backend.model.Cart;
import com.ecom.backend.model.User;
import com.ecom.backend.service.CartService;
import com.ecom.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestHeader("Authorization") String jwt, @RequestBody AddItemRequest req) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        cartService.addCartItem(user.getId(), req);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Item added to cart");
        apiResponse.setStatus(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
