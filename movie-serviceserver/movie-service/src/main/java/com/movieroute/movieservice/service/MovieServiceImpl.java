package com.movieroute.movieservice.service;

import com.movieroute.movieservice.MovieException.MovieException;
import com.movieroute.movieservice.MovieException.MovieNotFoundException;
import com.movieroute.movieservice.domain.Movie;
import com.movieroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service


public class MovieServiceImpl implements MovieService {


    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie newName) {
        /*int num = newName.getId();
        Movie already =  movieRepository.findById(num).get();
        try {
            if (already == null) {
                Movie movie = (Movie) movieRepository.save(newName);
                return movie;
            }
            else
                throw new MovieException("already exists");
        }
        catch (MovieException e)
        {
            e.printStackTrace();
            return null;
        }*/
        Movie movie = movieRepository.save(newName);
        return movie;
    }


    public List<Movie> getAll() throws MovieNotFoundException {
        List<Movie> movieList= movieRepository.findAll();

        if(movieList.size()!=0)
        return(List<Movie>) movieRepository.findAll();
        else
        {
            throw new MovieNotFoundException("sorry you have nothing in ur database");
        }
    }


    public Movie updateMovie(Movie movie) throws MovieNotFoundException {


           if( movieRepository.existsById(movie.getId()))
           {
               Movie movie1 = movieRepository.findById(movie.getId()).get();
               movie1.setComment(movie.getComment());

               movie1= movieRepository.save(movie1);
               return movie1;
           }
        else
            throw new MovieNotFoundException("not found");

        }






    public Boolean deleteMovie(Movie delName) throws MovieNotFoundException {

        Boolean check = false;

            if(movieRepository.existsById(delName.getId()))
            {
                movieRepository.delete(delName);
                check = true;
                return check;
            }
            else {

                throw new MovieNotFoundException("oops you gave a name which is not present");
            }

    }
    public Optional<Movie> getById(String id) throws MovieNotFoundException
    {

         if (movieRepository.existsById(id)) {
             Optional<Movie> movie1 = movieRepository.findById(id);
             return movie1;
         } else {

                throw new MovieNotFoundException("the id which u entered is not present");
         }



    }

    public List<Movie> getByName(String name) throws MovieNotFoundException {

        List<Movie> movie1 ;


            if((movie1=movieRepository.findByName(name)).size()!= 0)
            {
                return movie1;
            }
            else {

                throw new MovieNotFoundException("Not Found");
            }


    }
}
