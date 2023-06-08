package com.moviesApi.MoviesApp.controller;

import com.moviesApi.MoviesApp.service.MovieService;
import com.moviesApi.MoviesApp.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies(){
        return new ResponseEntity<List<Movies>>(movieService.AllMovies() , HttpStatus.OK);
    }


    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getSingleMovie(@PathVariable String imdbId){
          return new ResponseEntity<Optional<Movies>>(movieService.findMovieByImdbId(imdbId), HttpStatus.OK);
    }

}
