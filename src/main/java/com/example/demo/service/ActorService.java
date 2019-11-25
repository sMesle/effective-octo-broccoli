package com.example.demo.service;

import com.example.demo.model.Actor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    @HystrixCommand(fallbackMethod = "defaultActors")
    public List<Actor> getMovieActors(String movieName) {

        String sUrl = "http://localhost:5000/actors/movie/" + movieName;

        RestTemplate restTemplate = new RestTemplate();
        List<Actor> actorList = restTemplate.getForObject(sUrl, List.class);

        return actorList;
    }

    public List<Actor> defaultActors(String movieName) {
        List<Actor> defaultListActors = new ArrayList<>();
        Actor defaultActor = new Actor("default","actor", null);
        defaultListActors.add(defaultActor);

        return defaultListActors;
    }


}
