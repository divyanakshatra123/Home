package com.movieroute.movieservice.MovieException;

public class MovieNotFoundException extends Exception {

    private String message;
    public MovieNotFoundException(String message)
    {
        super(message);
        this.message=message;

    }

}
