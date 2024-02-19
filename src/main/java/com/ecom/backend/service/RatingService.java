package com.ecom.backend.service;

import com.ecom.backend.dao.request.RatingRequest;
import com.ecom.backend.exception.ProductException;
import com.ecom.backend.model.Rating;
import com.ecom.backend.model.User;

import java.util.List;

public interface RatingService {
    public Rating createRating(RatingRequest req, User user) throws ProductException;
    public List<Rating> getProductRating(Long productId);
}
