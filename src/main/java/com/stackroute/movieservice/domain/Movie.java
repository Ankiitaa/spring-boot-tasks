package com.stackroute.movieservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    private int movieId;
    private String movieTitle;
    private String overview;


}
