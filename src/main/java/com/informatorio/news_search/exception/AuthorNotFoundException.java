package com.informatorio.news_search.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message){
        super(message);
    }
}
