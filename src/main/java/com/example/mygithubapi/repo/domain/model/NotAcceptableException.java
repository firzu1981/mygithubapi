package com.example.mygithubapi.repo.domain.model;

public class NotAcceptableException extends RuntimeException{
    public NotAcceptableException(String message) {
        super(message);
    }
}
