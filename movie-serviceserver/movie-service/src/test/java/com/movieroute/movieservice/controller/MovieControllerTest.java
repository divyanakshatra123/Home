package com.movieroute.movieservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieroute.movieservice.MovieException.MovieNotFoundException;
import com.movieroute.movieservice.domain.Movie;
import com.movieroute.movieservice.service.MovieService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest

public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Movie movie;
    @MockBean
    private MovieService movieService;
    @InjectMocks
    private MovieController movieController;

    private List<Movie> list =null;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
        movie = new Movie();
        movie.setId("1");
        movie.setComment("ok ok");
        movie.setName("m1");
        movie.setUrl("shdhb");
        movie.setRating(3.5);
        list = new ArrayList<>();
        list.add(movie);


    }



    @Test
    public void saveSuccess() throws Exception {
        when(movieService.addMovie(any())).thenReturn(movie);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void saveSuccessFailure() throws Exception{
        when(movieService.addMovie(any())).thenThrow(MovieNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());

    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deleteSuccess() throws Exception{

        when(movieService.deleteMovie(any())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/movie/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void deleteFailure() throws Exception{

        when(movieService.deleteMovie(any())).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/movie/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateSuccess() throws Exception {
        when(movieService.updateMovie(any())).thenReturn(movie);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
    @Test
    public void updateFailure() throws Exception
    {
        when(movieService.updateMovie(any())).thenThrow(MovieNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getBymovienameSuccess() throws Exception{
        when(movieService.getByName(any())).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/{name}","m1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

@Test
public void getByMovieFailure() throws Exception
{
    when(movieService.getByName(any())).thenThrow(MovieNotFoundException.class);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/{name}","m1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(movie)))
            .andExpect(MockMvcResultMatchers.status().isConflict())
            .andDo(MockMvcResultHandlers.print());
}
    @Test
    public void getAllSuccess() throws Exception {

        when(movieService.getAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }
    @Test
    public void getAllFailure() throws Exception{
        when(movieService.getAll()).thenThrow(MovieNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}