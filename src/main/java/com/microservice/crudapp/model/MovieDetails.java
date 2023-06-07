package com.microservice.crudapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "moviedetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MovieDetails {
    @Id
    private String movieId;

    private String movieName;

    private String movieLanguage;

    private String movieCertificate;



}
