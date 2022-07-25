package com.informatorio.news_search.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String message){
        super(message);
    }
}
