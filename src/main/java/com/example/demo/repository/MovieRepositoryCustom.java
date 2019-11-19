package com.example.demo.repository;

import com.example.demo.model.Movie;

public interface MovieRepositoryCustom {

    public long updateMovie(String id, Movie movie);
}
