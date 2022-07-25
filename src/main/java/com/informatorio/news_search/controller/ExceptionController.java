package com.informatorio.news_search.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.informatorio.news_search.dto.ExceptionDTO;
import com.informatorio.news_search.exception.ArticleNotFoundException;
import com.informatorio.news_search.exception.AuthorNotFoundException;
import com.informatorio.news_search.exception.SourceNotFoundException;

@RestControllerAdvice
public class ExceptionController {
    
    @ResponseBody
    @ExceptionHandler({
        ArticleNotFoundException.class,
        AuthorNotFoundException.class,
        SourceNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDTO EntityNotFound(RuntimeException error){
        return new ExceptionDTO(error.getMessage());
    }
}
