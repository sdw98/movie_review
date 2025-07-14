package com.sdw.movie_review.service;

import com.sdw.movie_review.model.Movie;
import com.sdw.movie_review.model.Review;
import com.sdw.movie_review.repository.MovieRepository;
import com.sdw.movie_review.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public Review create(Long movieId, Review review) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new NoSuchElementException("영화가 없습니다: " + movieId));

        review.setMovie(movie);

        return reviewRepository.save(review);
    }
}
