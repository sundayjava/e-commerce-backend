package com.ecom.backend.service.serviceImpl;

import com.ecom.backend.dao.request.RatingRequest;
import com.ecom.backend.exception.ProductException;
import com.ecom.backend.model.Product;
import com.ecom.backend.model.Rating;
import com.ecom.backend.model.User;
import com.ecom.backend.repository.RatingRepository;
import com.ecom.backend.service.ProductService;
import com.ecom.backend.service.RatingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final ProductService productService;

    public RatingServiceImpl(RatingRepository ratingRepository, ProductService productService) {
        this.ratingRepository = ratingRepository;
        this.productService = productService;
    }

    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());

        Rating rating = new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductRating(Long productId) {
        return ratingRepository.getAllProductRating(productId);
    }
}
