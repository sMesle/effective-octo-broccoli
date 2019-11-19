package com.example.demo.controller;

import com.example.demo.model.Movie;

import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.MovieRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    /* Static db to test

    private static Map<Integer,Movie> myMap = new HashMap<>();
    static {
        myMap.put(1, new Movie("1", "test", "real", 2019));
        myMap.put(2, new Movie("2", "Prague", "Airbnb", 2019));
        myMap.put(3, new Movie("3", "Paris", "Booking", 2019));
    }*/

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private MovieRepositoryCustom movieRepositoryCustom;

    @Autowired
    private MovieRepository movieRepository;

    /*@GetMapping
    public Map<Integer, Movie> getMovies() {
        return myMap;
    }*/

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Movie> getMovieById(@PathVariable String id) {
        return movieRepository.findById(id);
    }

    @PutMapping(value = "/{id}")
    public String updateMovie(@PathVariable String id, @RequestBody Movie movie) {
        Query query1 = new Query(Criteria.where("id").is(id));
        Update update1 = new Update();
        update1.set("name", movie.getName());
        update1.set("realisator", movie.getRealisator());
        update1.set("year", movie.getYear());
        mongoTemplate.updateFirst(query1, update1, Movie.class);
        return "movie " + id + " updated";
    }

    @PostMapping
    Movie newMovie(@RequestBody Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteMovie(@PathVariable String id){
        movieRepository.deleteById(id);
        return "movie " + id + " removed";
    }


    /*@GetMapping(value = "/{id}")
    public Movie getMovieById(@PathVariable int id) {
        for (Map.Entry<Integer,Movie> entry : myMap.entrySet()) {
            if(entry.getKey() == id) {
                return entry.getValue();
            }
        }
        return null;
    }*/


    /*@PutMapping(value = "/{id}")
    public Movie putMovie(@RequestBody Movie movie, @PathVariable("id") int id ) {
        for (Map.Entry<Integer,Movie> entry : myMap.entrySet()) {
            if(entry.getKey() == id) {
                if(movie.getId() == null) {
                    movie.setId(entry.getValue().getId());
                }
                if(movie.getName() == null) {
                    movie.setName(entry.getValue().getName());
                }
                if(movie.getRealisator() == null) {
                    movie.setRealisator(entry.getValue().getRealisator());
                }
                if(movie.getYear() == 0) {
                    movie.setYear(entry.getValue().getYear());
                }
                myMap.put(id,movie);
                return entry.getValue();
            }
        }
        return null;
    }*/

    /*@DeleteMapping(value = "/{id}")
    public String deleteMovie(@PathVariable("id") int id) {
        myMap.remove(id);
        return "Movie " + id + " successfuly deleted";
    }*/

    /*@PutMapping(value = "/{id}")
    public Movie updateMovie(@PathVariable String id) {
    }*/
}
