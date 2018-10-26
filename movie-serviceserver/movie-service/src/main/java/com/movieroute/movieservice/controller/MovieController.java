package com.movieroute.movieservice.controller;

import com.movieroute.movieservice.MovieException.MovieNotFoundException;
import com.movieroute.movieservice.domain.Movie;
import com.movieroute.movieservice.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")

public class MovieController {

    private MovieService movieService;
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public void setMovieService(MovieService movieService){
        this.movieService = movieService;
    }

    @Autowired
    public MovieController( MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> save(@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try {
            Movie movie1 = movieService.addMovie(movie);
             responseEntity = new ResponseEntity<Movie>(movie1, HttpStatus.OK);
            return responseEntity;
        }
        catch (MovieNotFoundException e)
        {
            logger.error(e.getMessage());
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }
    }


    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> delete (@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
                try {
                    movieService.deleteMovie(movie);
                    responseEntity = new ResponseEntity(HttpStatus.OK);
                    return responseEntity;
                }
                catch (MovieNotFoundException e)
                {
                    responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
                    return responseEntity;
                }
    }


    @PutMapping("movie")
    public ResponseEntity<?> update(@RequestBody Movie movie)
    {   ResponseEntity responseEntity;
    try {
        Movie movie2 = movieService.updateMovie(movie);
        responseEntity = new ResponseEntity<Movie>(movie2, HttpStatus.OK);
        return responseEntity;
    }
    catch (MovieNotFoundException e)
    {
        responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        return responseEntity;
    }
    }


    @GetMapping("movie/{name}")
    public ResponseEntity<?>  getBymoviename(@PathVariable("name") String n)
    {       ResponseEntity responseEntity ;
        try{

            List<Movie> movieList = movieService.getByName(n) ;
              responseEntity = new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
              return responseEntity;
        }
        catch (MovieNotFoundException e)
        {
               responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
               return responseEntity;
        }
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAll()
    {
        ResponseEntity responseEntity;
       try {
           List<Movie> movieList;
           movieList = movieService.getAll();
           responseEntity = new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
           return responseEntity;
       }
       catch (MovieNotFoundException e)
       {
           responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
           return responseEntity;
       }
   }


}
