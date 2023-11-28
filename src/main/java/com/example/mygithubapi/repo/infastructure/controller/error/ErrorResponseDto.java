package com.example.mygithubapi.repo.infastructure.controller.error;

import org.springframework.http.HttpStatus;

public record ErrorResponseDto(String message, HttpStatus httpStatus) {

}
