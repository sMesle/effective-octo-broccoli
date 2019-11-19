package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import com.example.demo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

// This is an Interface.
// No need Annotation here
public interface MovieRepository extends MongoRepository<Movie, String> { // Long: Type of Employee ID.


}