package com.DesafioUbots.services;

import com.DesafioUbots.dtos.ReviewDTO;
import com.DesafioUbots.models.Movie;
import com.DesafioUbots.models.Review;
import com.DesafioUbots.repositories.MovieRepository;
import com.DesafioUbots.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    public Optional<Review> createReview(ReviewDTO reviewDTO) {
        Optional<Movie> movieOptional = movieRepository.findById(reviewDTO.movieId());
        if (movieOptional.isEmpty()) {
            return Optional.empty(); // Movie not found
        }

        int rating = reviewDTO.rating();
        if (rating < 1 || rating > 5) {
            return Optional.empty(); // Invalid rating value
        }

        Movie movie = movieOptional.get();
        Review review = new Review(movie, rating);
        return Optional.of(reviewRepository.save(review));
    }
}
