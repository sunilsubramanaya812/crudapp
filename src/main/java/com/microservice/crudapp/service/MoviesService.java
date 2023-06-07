package com.microservice.crudapp.service;


import com.microservice.crudapp.configuration.MethodArgumentNotValidException;
import com.microservice.crudapp.configuration.ResourceNotFoundException;
import com.microservice.crudapp.dto.MovieDetailsRequest;
import com.microservice.crudapp.model.MovieDetails;
import com.microservice.crudapp.repository.MovieDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class MoviesService {

    @Autowired
    MovieDetailsRepository movieDetailsRepository;

//    @Cacheable(cacheNames = "moviedetails", key = "#movieID")
    public MovieDetails getMovieDetail(String movieID)  {
        MovieDetails movieDetails = movieDetailsRepository.findById(movieID).orElseThrow(() -> new ResourceNotFoundException("we don't have movie details belongs to this id "+ movieID));
        return movieDetails;
    }


//    @CacheEvict(cacheNames = "moviedetails")
    public MovieDetails addMovie(MovieDetailsRequest movieDetailsRequest) {

        MovieDetails movieDetails = MovieDetails.builder()
                .movieName(movieDetailsRequest.getMovieName())
                .movieLanguage(movieDetailsRequest.getMovieLanguage())
                .movieCertificate(movieDetailsRequest.getMovieCertificate())
                .movieId(UUID.randomUUID().toString()).build();
        MovieDetails details = movieDetailsRepository.save(movieDetails);
    return details;
    }

//    @CachePut(cacheNames = "movieDetails", key = "#movieID")
    public MovieDetails updateMovie(String movieID, MovieDetailsRequest movieDetailsRequest) {

      if (movieDetailsRepository.existsById(movieID) == false){
          new ResourceNotFoundException("please enter valid movie detail id");
      }
      Integer result =  movieDetailsRepository.setMovieDetailsById(movieDetailsRequest.getMovieName(), movieDetailsRequest.getMovieLanguage(), movieDetailsRequest.getMovieCertificate(), movieID);
        if (result == 0) {
            new ResourceNotFoundException("not updated");
        }
      return movieDetailsRepository.findById(movieID).get();
    }
//    @CacheEvict(cacheNames = "movieDetails", key = "#movieID")
    public String deleteMovie(String movieID){
        String name = "";
        if (movieDetailsRepository.existsById(movieID) == false){
            new ResourceNotFoundException("please enter valid movie detail id");
        }
        try {
            movieDetailsRepository.deleteById(movieID);
            name = "successfully delete movie id " + movieID;
        }catch (Exception e) {
            new MethodArgumentNotValidException("invalid movie id");

        }
        return name;
    }

}
