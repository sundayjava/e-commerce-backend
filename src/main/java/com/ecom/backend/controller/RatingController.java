package com.ecom.backend.controller;

import com.ecom.backend.dao.request.RatingRequest;
import com.ecom.backend.exception.ProductException;
import com.ecom.backend.exception.UserException;
import com.ecom.backend.model.Rating;
import com.ecom.backend.model.User;
import com.ecom.backend.service.RatingService;
import com.ecom.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired
    private UserService userService;
    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        Rating rating = ratingService.createRating(req, user);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductsRating(@RequestHeader("Authorization") String jwt, @PathVariable Long productId) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        List<Rating> ratings = ratingService.getProductRating(productId);
        return new ResponseEntity<>(ratings, HttpStatus.CREATED);
    }
}
