package com.DesafioUbots.controllers;

import com.DesafioUbots.dtos.ReviewDTO;
import com.DesafioUbots.models.Review;
import com.DesafioUbots.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Object> createReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        Optional<Review> createdReview = reviewService.createReview(reviewDTO);

        if (createdReview.isPresent()) {
            Review review = createdReview.get();
            return ResponseEntity.status(HttpStatus.CREATED).body(review);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
        }
    }

}
