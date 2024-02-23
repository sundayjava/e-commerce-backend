package com.ecom.backend.controller;

import com.ecom.backend.dao.request.ReviewRequest;
import com.ecom.backend.exception.ProductException;
import com.ecom.backend.exception.UserException;
import com.ecom.backend.model.Reviews;
import com.ecom.backend.model.User;
import com.ecom.backend.service.ReviewService;
import com.ecom.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Reviews> createReview(@RequestBody ReviewRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        Reviews review = reviewService.createReview(req,user);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Reviews>> getProductsReview(@PathVariable Long productId){
        List<Reviews> reviews = reviewService.getAllReviews(productId);
        return new ResponseEntity<>(reviews,HttpStatus.ACCEPTED);
    }
}
