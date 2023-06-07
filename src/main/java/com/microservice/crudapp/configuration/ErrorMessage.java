package com.microservice.crudapp.configuration;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorMessage {

    private int statusCode;

    private Date date;

    private String errorMessage;

}
