package com.microservice.crudapp.controller;


import com.microservice.crudapp.configuration.MethodArgumentNotValidException;
import com.microservice.crudapp.configuration.ResourceNotFoundException;
import com.microservice.crudapp.dto.MovieDetailsRequest;
import com.microservice.crudapp.model.MovieDetails;
import com.microservice.crudapp.repository.MovieDetailsRepository;
import com.microservice.crudapp.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class MovieDetailsController {


    @Autowired
    MovieDetailsRepository movieDetailsRepository;

    @Autowired
    MoviesService moviesService;


    @GetMapping
    @RequestMapping("/movieDetails/{movieID}")
    public ResponseEntity<MovieDetails> getMovieDetails(@PathVariable("movieID")String movieID) {
    MovieDetails movieDetails = moviesService.getMovieDetail(movieID);
    return new ResponseEntity<>(movieDetails, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/allMovies")
    public ResponseEntity<List<MovieDetails>> getAllMovies(){
        if ( movieDetailsRepository.count() < 0) {
         new ResourceNotFoundException("We don't any data as of now");
        }
            List<MovieDetails> movieDetails =movieDetailsRepository.findAll();
            return new ResponseEntity<>(movieDetails, HttpStatus.OK);

    }


    @PostMapping
    @RequestMapping("/addMovieDetails")
    public ResponseEntity<MovieDetails> addMovieDetails(@RequestBody MovieDetailsRequest movieDetailsRequest) {
        if (movieDetailsRequest == null) {
            new MethodArgumentNotValidException("BAD Content");
        }

        MovieDetails movieDetails = moviesService.addMovie(movieDetailsRequest);
                   return new ResponseEntity<>(movieDetails, HttpStatus.CREATED);
    }

    @PutMapping
    @RequestMapping("/updateMovieDetails/{movieID}")
    public ResponseEntity<MovieDetails> updateMovieDetails(@PathVariable("movieID")String movieID, @RequestBody MovieDetailsRequest movieDetailsRequest) {
        if (movieDetailsRequest == null) {
            new MethodArgumentNotValidException("BAD Content");
        }

        MovieDetails movieDetails = moviesService.updateMovie(movieID,movieDetailsRequest);
        return new ResponseEntity<>(movieDetails, HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("/deleteMovieDetails/{movieID}")
    public ResponseEntity<String> deleteMovieDetails(@PathVariable("movieID")String movieID) {
        if (movieID == null || movieID.isBlank() || movieID.isEmpty()) {
            new MethodArgumentNotValidException("BAD Content");
        }

        String movieDetails = moviesService.deleteMovie(movieID);
        return new ResponseEntity<>(movieDetails, HttpStatus.OK);
    }


}
