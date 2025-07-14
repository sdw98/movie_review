package com.sdw.movie_review.controller;

import com.sdw.movie_review.dto.MovieDto;
import com.sdw.movie_review.model.Movie;
import com.sdw.movie_review.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public Movie create(@Valid @RequestBody MovieDto movieDto) {
        Movie movie = new Movie();

        movie.setTitle(movieDto.getTitle());
        movie.setReleaseYear(movie.getReleaseYear());

        return movieService.create(movie);
    }
}
