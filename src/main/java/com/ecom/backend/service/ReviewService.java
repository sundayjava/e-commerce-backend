package com.ecom.backend.service;

import com.ecom.backend.dao.request.ReviewRequest;
import com.ecom.backend.exception.ProductException;
import com.ecom.backend.model.Reviews;
import com.ecom.backend.model.User;

import java.util.List;

public interface ReviewService {
    public Reviews createReview(ReviewRequest req, User user) throws ProductException;
    public List<Reviews> getAllReviews(Long productId);
}
