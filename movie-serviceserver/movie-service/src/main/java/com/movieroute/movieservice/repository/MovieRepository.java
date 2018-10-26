package com.movieroute.movieservice.repository;

import com.movieroute.movieservice.domain.Movie;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MovieRepository extends MongoRepository<Movie,String> {

   //@Query(value = "SELECT * FROM MOVIE WHERE NAME =?1", nativeQuery = true)
    List<Movie> findByName(String name);
}
