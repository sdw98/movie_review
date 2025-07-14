package com.sdw.movie_review.service;

import com.sdw.movie_review.model.Movie;
import com.sdw.movie_review.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }
}
