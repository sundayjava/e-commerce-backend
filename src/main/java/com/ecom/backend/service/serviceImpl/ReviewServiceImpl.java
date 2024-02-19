package com.ecom.backend.service.serviceImpl;

import com.ecom.backend.dao.request.ReviewRequest;
import com.ecom.backend.exception.ProductException;
import com.ecom.backend.model.Product;
import com.ecom.backend.model.Reviews;
import com.ecom.backend.model.User;
import com.ecom.backend.repository.ProductRepository;
import com.ecom.backend.repository.ReviewRepository;
import com.ecom.backend.service.ProductService;
import com.ecom.backend.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductService productService, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public Reviews createReview(ReviewRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());

        Reviews reviews = new Reviews();
        reviews.setUser(user);
        reviews.setProduct(product);
        reviews.setReview(req.getReview());
        reviews.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(reviews);
    }

    @Override
    public List<Reviews> getAllReviews(Long productId) {
        return reviewRepository.getAllProductReviews(productId);
    }
}
