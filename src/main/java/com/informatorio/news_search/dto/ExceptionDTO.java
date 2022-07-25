package com.informatorio.news_search.dto;

public class ExceptionDTO {
    private String error;

    public ExceptionDTO() {}
    public ExceptionDTO(String error) {
        this.error = error;
    }
    
    public String getError() {
        return error;
    }
}
