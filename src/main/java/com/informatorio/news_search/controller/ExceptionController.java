package com.informatorio.news_search.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.informatorio.news_search.dto.exception.NotFoundExceptionDTO;
import com.informatorio.news_search.exception.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionController {
    @ResponseBody
    @ExceptionHandler({
        EntityNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundExceptionDTO entityNotFound(EntityNotFoundException error){
        return new NotFoundExceptionDTO(error.getName(), error.getMessage());
    }
}
