package com.example.demo.service;

import com.example.demo.model.Actor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    private final CircuitBreakerFactory circuitBreakerFactory;

    public ActorService(CircuitBreakerFactory circuitBreakerFactory) {
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    public List<Actor> getMovieActors(String movieName) {
        RestTemplate restTemplate = new RestTemplate();

        return circuitBreakerFactory.create("getMovieActors").run(
                () -> (List<Actor>) restTemplate.getForObject("http://apppython:5000/actors/movie/" + movieName, List.class),
                t -> defaultActors()
        );
    }

    public List<Actor> defaultActors() {
        List<Actor> defaultListActors = new ArrayList<>();
        Actor defaultActor = new Actor("default","actor", null);
        defaultListActors.add(defaultActor);

        return defaultListActors;
    }


}
