package com.example.demo.repository;

import com.example.demo.model.Movie;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;



@Repository
public class MovieRepositoryCustomImpl implements MovieRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public long updateMovie(String id, Movie movie) {
        Query query = new Query(Criteria.where("id").is(movie.getId()));
        Update update = new Update();
        update.set("name", movie.getName());
        update.set("realisator", movie.getRealisator());
        update.set("year", movie.getYear());
        UpdateResult result = this.mongoTemplate.updateFirst(query, update, Movie.class);

        if (result != null) {
            return result.getModifiedCount();
        }

        return 0;
    }
}
