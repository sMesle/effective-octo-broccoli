package com.example.demo.model;

public class Actor {

    private String firstname;
    private String lastname;
    private String movieName;

    public Actor(String firstname, String lastname, String movieName) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.movieName = movieName;
    }

    public Actor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
