package com.ecom.backend.dao.request;

public class RatingRequest {
    private Long productId;
    private double rating;

    public RatingRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
