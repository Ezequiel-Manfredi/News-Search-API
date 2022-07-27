package com.informatorio.news_search.dto.exception;

public class NotFoundExceptionDTO {
    private String name;
    private String error;

    public NotFoundExceptionDTO() {}
    public NotFoundExceptionDTO(String name, String error) {
        this.name = name;
        this.error = error;
    }
    
    public String getName() {
        return name;
    }
    public String getError() {
        return error;
    }
}
