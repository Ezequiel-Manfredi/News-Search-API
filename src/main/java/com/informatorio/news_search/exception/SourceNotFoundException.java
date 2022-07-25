package com.informatorio.news_search.exception;

public class SourceNotFoundException extends RuntimeException {
    public SourceNotFoundException(String message){
        super(message);
    }
}
