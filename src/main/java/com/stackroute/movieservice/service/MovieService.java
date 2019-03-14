package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    public Movie addMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies();
    public Optional<Movie> getMovieById(int id) throws MovieNotFoundException;
    public void delById(int id);
    public Movie update(Movie movie,int id);
    public List<Movie> findBymovieTitle(String movieTitle);
}
