package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "Movie")
public class Movie {

    @Id
    private String id;
    @Field(value = "Name")
    private String name;
    @Field(value = "Realisator")
    private String realisator;
    @Field(value = "Year")
    private int year;

    private List<Actor> actors;

    public Movie(String id, String name, String realisator, int year) {
        this.id = id;
        this.name = name;
        this.realisator = realisator;
        this.year = year;
    }

    public Movie(String id, String name, String realisator, int year, List<Actor> actors) {
        this.id = id;
        this.name = name;
        this.realisator = realisator;
        this.year = year;
        this.actors = actors;
    }

    public Movie(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealisator() {
        return realisator;
    }

    public void setRealisator(String realisator) {
        this.realisator = realisator;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
