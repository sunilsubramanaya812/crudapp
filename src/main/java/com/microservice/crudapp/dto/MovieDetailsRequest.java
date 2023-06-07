package com.microservice.crudapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailsRequest {

    private String movieName;

    private String movieLanguage;

    private String movieCertificate;
}
