package com.stackroute.movieservice.listener;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.repository.MovieRepository;
import com.stackroute.movieservice.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class DBInitializer implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private MovieRepository movieRepository;


    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    Environment env;


    @Value("${movieId}")
    int movieId;

    @Value("${overview}")
    String overview;


    @Override
    public void run(String... args) throws Exception {
        Movie movie = new Movie(2, "PK", "Worth watching");

        this.movieRepository.save(movie);

    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            movieService.addMovie(new Movie(movieId, env.getProperty("movieTitle"), overview));
        } catch (MovieAlreadyExistsException e) {
            e.printStackTrace();
        }

    }
}
