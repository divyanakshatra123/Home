package com.movieroute.movieservice.service;

import com.movieroute.movieservice.MovieException.MovieNotFoundException;
import com.movieroute.movieservice.domain.Movie;
import com.movieroute.movieservice.repository.MovieRepository;
import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieServiceTest {
    Movie movie;

    @Mock
    MovieRepository movieRepository;
    @InjectMocks
    MovieServiceImpl movieService;
    List<Movie> list = null;




    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        movie = new Movie();
        movie.setId("1");
        movie.setRating(3.4);
        movie.setUrl("google.com");
        movie.setName("m1");
        movie.setComment("wow");

        list = new ArrayList<>();
        list.add(movie);

    }

    @Test
    public void addMovieSuccess() throws Exception{


       when(movieRepository.save((Movie) ArgumentMatchers.any())).thenReturn(movie);
        Movie res = movieService.addMovie(movie);
        Assert.assertEquals(movie,res);
        verify(movieRepository,times(1)).save(movie);

    }
    @Test
    public void addMovieFailure() throws Exception
    {
       when(movieRepository.save((Movie) ArgumentMatchers.any())).thenReturn(null);
        Movie res = movieService.addMovie(movie);
        Assert.assertNotEquals(movie,res);


    }

    @Test
    public void getAllSuccess() throws Exception{
        movieRepository.save(movie);
        //stubbing the mock to return specific data
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> userlist = movieService.getAll();
        Assert.assertEquals(list,userlist);
        verify(movieRepository,times(1)).save(movie);

    }
    @Test
    public void getAllFailure() throws Exception
    {

        when(movieRepository.save((Movie) ArgumentMatchers.any())).thenReturn(null);
        List<Movie> res = movieService.getAll();
        Assert.assertNotEquals(list,res);
        verify(movieRepository,times(1)).save(movie);

    }
    @Test
    public void updateMovieSuccess() throws Exception {
        Mockito.when(movieRepository.save(movie)).thenReturn(movie);
        Mockito.when(movieRepository.existsById(any())).thenReturn(true);
        Mockito.when(movieRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(movie));

        movie.setComment("wow its good");
        Movie res = movieService.updateMovie(movie);
        assertEquals("wow its good",res.getComment());
        verify(movieRepository,times(1)).save(movie);
        verify(movieRepository,times(1)).existsById(movie.getId());
        verify(movieRepository,times(1)).findById(movie.getId());
    }

    @Test
    public void udateMovieFailure() throws MovieNotFoundException
    {
        Mockito.when(movieRepository.save(movie)).thenReturn(movie);
        Mockito.when(movieRepository.existsById(any())).thenReturn(true);
        Mockito.when(movieRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(movie));
        movie.setComment("wow its good");
        Movie res = movieService.updateMovie(movie);
        assertNotEquals("wow ",res.getComment());
        verify(movieRepository,times(1)).save(movie);
        verify(movieRepository,times(1)).existsById(movie.getId());
        verify(movieRepository,times(1)).findById(movie.getId());
    }




    @Test
    public void deleteMovieSuccess() throws MovieNotFoundException {
        Mockito.when(movieRepository.existsById(movie.getId())).thenReturn(true);
        doNothing().when(movieRepository).delete(movie);
        Boolean res = movieService.deleteMovie(movie);
        assertTrue(res);
        verify(movieRepository,times(1)).existsById(movie.getId());
        verify(movieRepository,times(1)).delete(movie);


    }
    @Test(expected = MovieNotFoundException.class)
    public void deleteMovieFailure() throws MovieNotFoundException
    {

        Mockito.when(movieRepository.existsById(movie.getId())).thenReturn(false);
        doNothing().when(movieRepository).delete(movie);
        Boolean res = movieService.deleteMovie(movie);
        assertFalse(res);

        verify(movieRepository,times(1)).existsById(movie.getId());
        verify(movieRepository,times(1)).delete(movie);
    }



    @Test
    public void getByName() throws MovieNotFoundException{
        Mockito.when(movieRepository.findByName("m1")).thenReturn(list);
        List<Movie> movieList = new ArrayList<>();
        movieList = movieService.getByName("m1");
        if(list.size()==movieList.size()) {
            for (int i = 0; i < list.size(); i++) {
                Assert.assertEquals(list.get(i).toString(), movieList.get(i).toString());
            }
        }
    }

    @Test(expected = MovieNotFoundException.class)
    public void getByNameFailure() throws MovieNotFoundException
    {
        Mockito.when(movieRepository.findByName("m2")).thenReturn(list);
        List<Movie> movieList = new ArrayList<>();
        movieList = movieService.getByName("m1");
        if(list.size()==movieList.size()) {
            for (int i = 0; i < list.size(); i++) {
                Assert.assertNotEquals(list.get(i).toString(), movieList.get(i).toString());
            }
        }
    }
}