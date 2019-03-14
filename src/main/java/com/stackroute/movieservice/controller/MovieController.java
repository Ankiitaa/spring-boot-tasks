package com.stackroute.movieservice.controller;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException {
        ResponseEntity<?> responseEntity;
//        try {
            responseEntity = new ResponseEntity<Movie>(movieService.addMovie(movie), HttpStatus.OK);
//        } catch (MovieAlreadyExistsException e) {
//            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//        }
        return responseEntity;
    }



    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }
    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable int id) throws MovieNotFoundException{
//        try {
            return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id), HttpStatus.OK);
//        }
//        catch (MovieNotFoundException e){
//            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//        }
    }
    @DeleteMapping("/movie/{id}")
    public void deleteById(@PathVariable int id){
        movieService.delById(id);
    }
    @PutMapping("/movie/{id}")
    public ResponseEntity<Object> update(@RequestBody Movie user,@PathVariable int id){
        return new ResponseEntity<Object>(movieService.update(user,id),HttpStatus.OK);
    }
    @GetMapping("/moviess/{movieTitle}")
    public ResponseEntity<List<Movie>> getMovieByName(@PathVariable String movieTitle){
        return new ResponseEntity<List<Movie>>(movieService.findBymovieTitle(movieTitle),HttpStatus.OK);
    }

}
