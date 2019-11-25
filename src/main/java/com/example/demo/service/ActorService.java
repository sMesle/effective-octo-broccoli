package com.example.demo.service;

import com.example.demo.model.Actor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class ActorService {

    public List<Actor> getMovieActors(String movieName) {

        String sUrl = "http://localhost:5000/actors/movie/" + movieName;

        RestTemplate restTemplate = new RestTemplate();
        List<Actor> actorList = restTemplate.getForObject(sUrl, List.class);

        return actorList;

    }
}
