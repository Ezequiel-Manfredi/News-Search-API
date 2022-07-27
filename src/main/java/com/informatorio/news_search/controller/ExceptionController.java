package com.informatorio.news_search.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.informatorio.news_search.dto.exception.InvalidFieldExceptionDTO;
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

    @ResponseBody
    @ExceptionHandler({
        MethodArgumentNotValidException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<InvalidFieldExceptionDTO> invalidArguments(MethodArgumentNotValidException errors) {
        return errors
            .getBindingResult()
            .getAllErrors()
            .stream()
            .map(error -> 
                new InvalidFieldExceptionDTO(
                    ((FieldError) error).getField(), 
                    error.getDefaultMessage()
                )
            )
            .collect(Collectors.toList());
    }
}
