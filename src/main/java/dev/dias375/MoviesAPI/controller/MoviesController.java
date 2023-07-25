package dev.dias375.MoviesAPI.controller;

import dev.dias375.MoviesAPI.model.Movie;
import dev.dias375.MoviesAPI.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;


    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(moviesService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId){
        return new ResponseEntity<>(moviesService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
