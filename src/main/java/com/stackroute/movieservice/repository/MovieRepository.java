package com.stackroute.movieservice.repository;

import com.stackroute.movieservice.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie,Integer> {

    @Query(value = "select m from Movie m where m.movieTitle=?1")
    public List<Movie> findBymovieTitle(String movieTitle);
}

