package com.moviesApi.MoviesApp.service;

import com.moviesApi.MoviesApp.model.Movies;
import com.moviesApi.MoviesApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movies>AllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movies> findMovieByImdbId(String imdbId)
    {
        return movieRepository.findMovieByImdbId(imdbId);
    }


}
