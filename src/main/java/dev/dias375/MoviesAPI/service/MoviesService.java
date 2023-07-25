package dev.dias375.MoviesAPI.service;

import dev.dias375.MoviesAPI.model.Movie;
import dev.dias375.MoviesAPI.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movie> getAllMovies(){
        return moviesRepository.findAll();
    }

    public Optional<Movie> getMovieByImdbId(String imdbId){
        return moviesRepository.findMovieByImdbId(imdbId);
    }
}
