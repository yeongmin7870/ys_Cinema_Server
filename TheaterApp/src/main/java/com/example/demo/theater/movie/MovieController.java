package com.example.demo.theater.movie;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/theater")
@CrossOrigin
public class MovieController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieDaoService service;

    @GetMapping("/movies")
    public List<Movie> retrieveAllMovies () {
        return service.findAll();
    }

    @GetMapping("/movie/{movieid}")
    public Movie retrieveMovies(@PathVariable Integer movieId) {
        Movie movie = service.findById(movieId);

        if (movie == null) {
            throw new MovieNotFoundException(String.format("ID [%s] not found", movieId));
        }

        return movie;
    }


    @PostMapping("/movies")
    public ResponseEntity<Movie> newMovies (@RequestBody Movie newMovie) {

        Movie insertMovie = service.findById(newMovie.getMovieId());

        if (insertMovie == null) {
            service.save(newMovie);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newMovie.getMovieId())
                    .toUri();
            return ResponseEntity.created(location).build();
        } else{
            throw new MovieNotFoundException(String.format("ID [%s] already exist", insertMovie.getMovieId()));
        }
    }

}
