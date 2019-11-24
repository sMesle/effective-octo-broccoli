package com.example.demo.service;

import com.example.demo.model.Movie;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

    long updateMovie(String id, Movie movie);
    Collection<Movie> getAllMovies();
    Optional<Movie> findMovieById(String id);
    void createMovies(List<Movie> movieList);
    void deleteMovieById(String id);

}
