package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.service.ActorService;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorService actorService;

    @GetMapping
    public Collection<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{id}")
    public Optional<Movie> getMovieById(@PathVariable String id) {
        return movieService.findMovieById(id);
    }

    @GetMapping(value = "{movieName}/actors")
    public List<Actor> getActorMovies(@PathVariable String movieName) {
        return actorService.getMovieActors(movieName);
    }

    @PutMapping(value = "/{id}")
    public long updateMovie(@PathVariable String id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @PostMapping
    public void createMovie(@RequestBody List<Movie> movieList) {
        movieService.createMovies(movieList);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMovie(@PathVariable String id){
        movieService.deleteMovieById(id);

    }
}
