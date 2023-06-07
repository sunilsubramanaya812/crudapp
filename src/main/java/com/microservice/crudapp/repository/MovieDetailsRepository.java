package com.microservice.crudapp.repository;

import com.microservice.crudapp.model.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetails, String> {
    @Modifying
    @Query("update moviedetails m set m.movieName = ?1, m.movieLanguage = ?2, m.movieCertificate =?3 where m.movieId = ?4")
    Integer setMovieDetailsById(String movieName, String movieLanguage,String movieCertificate, String movieId);
}
