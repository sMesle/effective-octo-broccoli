package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Collection<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public void createMovies(List<Movie> movieList) {
        movieRepository.saveAll(movieList);
    }

    @Override
    public void deleteMovieById(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public long updateMovie(String id, Movie movie) {
        Query query = new Query(Criteria.where(id).is(movie.getId()));
        Update update = new Update();

        if(movie.getName() != null) {
            update.set("name", movie.getName());
        }
        if(movie.getRealisator() != null) {
            update.set("realisator", movie.getRealisator());
        }
        if(movie.getYear() != 0) {
            update.set("year", movie.getYear());
        }

        UpdateResult result = this.mongoTemplate.updateFirst(query, update, Movie.class);

        if (result != null) {
            return result.getModifiedCount();
        }

        return 0;
    }
}
