package com.sdw.movie_review.controller;

import com.sdw.movie_review.dto.ReviewDto;
import com.sdw.movie_review.model.Review;
import com.sdw.movie_review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/api/movies/{movieId}/reviews")
    public Review add(
            @PathVariable Long movieId,
            @Valid @RequestBody ReviewDto reviewDto
    ) {
        Review review = new Review();
        review.setReviewer(reviewDto.getReviewer());
        review.setRating(reviewDto.getRating());
        review.setComment(reviewDto.getComment());

        return reviewService.create(movieId, review);
    }
}
