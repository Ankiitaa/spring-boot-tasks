package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    //AQdding a new movie
    @Override
    public Movie addMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getMovieId())){
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        Movie savedMovie= movieRepository.save(movie);
        if(savedMovie==null){
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        return savedMovie;
    }

    //getting all movies

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }


    //Getting a movie by id
    @Override
    public Optional<Movie> getMovieById(int id) throws MovieNotFoundException {
        if(!movieRepository.existsById(id))
        {
            throw new MovieNotFoundException("Movie not found");
        }
        return movieRepository.findById(id);
    }


    //deleting a movie by its id

    @Override
    public void delById(int id) {
        movieRepository.deleteById(id);
    }


    //Updating the details of a movie
    @Override
    public Movie update(Movie movie, int id) {
        Movie movieUpdated = movieRepository.findById(id).get();
        movieUpdated.setOverview(movie.getOverview());
        return movieRepository.save(movieUpdated);
    }


    //Finfing movie by its name

    public List<Movie> findBymovieTitle(String movieTitle) {

        return movieRepository.findBymovieTitle(movieTitle);

    }




}
