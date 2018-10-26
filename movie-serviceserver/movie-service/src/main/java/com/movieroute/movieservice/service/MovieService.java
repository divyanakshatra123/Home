package com.movieroute.movieservice.service;

import com.movieroute.movieservice.MovieException.MovieNotFoundException;
import com.movieroute.movieservice.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    public Movie addMovie(Movie newName ) throws MovieNotFoundException;

    public List<Movie> getAll() throws MovieNotFoundException;

    public Movie updateMovie(Movie movie) throws MovieNotFoundException;

    public Boolean deleteMovie (Movie delName) throws MovieNotFoundException;

    public Optional<Movie> getById(String id) throws MovieNotFoundException;
    public List<Movie> getByName(String name) throws MovieNotFoundException;

}
