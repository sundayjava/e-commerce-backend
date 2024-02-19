package com.ecom.backend.repository;

import com.ecom.backend.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    @Query("SELECT r FROM Reviews r WHERE r.product.id=:productId")
    public List<Reviews> getAllProductReviews(@Param("productId") Long productId);
}
