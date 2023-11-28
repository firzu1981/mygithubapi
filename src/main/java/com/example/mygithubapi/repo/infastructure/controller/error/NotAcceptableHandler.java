package com.example.mygithubapi.repo.infastructure.controller.error;

import com.example.mygithubapi.MyGithubApiApplication;
import com.example.mygithubapi.repo.domain.model.NotAcceptableException;
import com.example.mygithubapi.repo.domain.model.UsernameNotFoundException;
import com.example.mygithubapi.repo.infastructure.controller.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = RestController.class)
public class NotAcceptableHandler {
    Logger logger = LoggerFactory.getLogger(MyGithubApiApplication.class);
    @ExceptionHandler(NotAcceptableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleException(NotAcceptableException exception){
        logger.warn("Not acceptable header");
        return new ErrorResponseDto(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
