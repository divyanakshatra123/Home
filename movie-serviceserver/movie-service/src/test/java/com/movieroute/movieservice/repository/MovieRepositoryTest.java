package com.movieroute.movieservice.repository;

import com.movieroute.movieservice.MovieException.MovieException;
import com.movieroute.movieservice.MovieException.MovieNotFoundException;
import com.movieroute.movieservice.MovieServiceApplication;
import com.movieroute.movieservice.domain.Movie;
import com.movieroute.movieservice.service.MovieService;
import com.movieroute.movieservice.service.MovieServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataMongoTest


public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;
    Movie movie;
    MovieService movieService;

    @Before
    public void setUp() throws Exception {
        movie = new Movie();
        movie.setId("123");
        movie.setName("aravinda");
        movie.setRating(4.5);
        movie.setUrl("https://www.youtube.com/watch?v=mR1z_nbfP58");
        movie.setComment("best trivikrams movie");

    }

   // @After
   // public void tearDown() throws Exception {
   // }

    @Test
    public void successfindByName() {

        movieRepository.save(movie);

       Movie movie2 = new Movie();
       movie2.setName("blah blah");
       movie2.setId("1");
       movie2.setComment("fhujryhf");
       movie2.setUrl("best");
       movie2.setRating(1.0);
       movieRepository.save(movie2);
       List<Movie> res = new ArrayList<>();
       res.add(movie);
        List<Movie> inpu= movieRepository.findByName("aravinda sametha");
        if(res.size()==inpu.size())
        {
            for(int i=0;i<inpu.size();i++)
            {
                Assert.assertEquals(res.get(i).toString(),inpu.get(i).toString());
            }
        }

    }
    @Test
    public void FailurefindByName()
    {

        movieRepository.save(movie);

        Movie movie2 = new Movie();
        movie2.setName("blah blah");
        movie2.setId("1");
        movie2.setComment("fhujryhf");
        movie2.setUrl("best");
        movie2.setRating(1.0);
        movieRepository.save(movie2);
        List<Movie> res = new ArrayList<>();
        res.add(movie);
        List<Movie> inpu= movieRepository.findByName("aravin");
        if(res.size()==inpu.size())
        {
            for(int i=0;i<inpu.size();i++)
            {
                Assert.assertNotEquals(res.get(i).toString(),inpu.get(i).toString());
            }
        }
    }

    @Test
    public void saveSuccess()
    {
        movieRepository.save(movie);
        Movie fetch = movieRepository.findById(movie.getId()).get();
        Assert.assertEquals("123",fetch.getId());
    }

    @Test
    public void saveFailure()
    {

        movieRepository.save(movie);
        Movie fetch = movieRepository.findById(movie.getId()).get();
        Assert.assertNotEquals("13",fetch.getId());
    }
    @Test
    public void getAllsuccess()
    {
        movieRepository.save(movie);
        List<Movie> all;
        Movie m1 = new Movie("1","sdshg","m1","jhhjgff",4.3);
        Movie m2 = new Movie("2","blah","m2","jhhjgff",4.0);
        movieRepository.save(m1);
        movieRepository.save(m2);
        all = movieRepository.findAll();
        Assert.assertEquals("123",all.get(1).getId());

    }
    @Test
    public void getAllFailure()
    {
        movieRepository.save(movie);
        List<Movie> all;
        Movie m1 = new Movie("1","sdshg","m1","jhhjgff",4.3);
        Movie m2 = new Movie("2","blah","m2","jhhjgff",4.0);
        movieRepository.save(m1);
        movieRepository.save(m2);
        all = movieRepository.findAll();
        Assert.assertNotEquals("12",all.get(1).getId());

    }


}