package com.informatorio.news_search.exception;

public class EntityNotFoundException extends RuntimeException {
    private String name = "entity";
    private String message = "notFound";

    public EntityNotFoundException() {}
    public EntityNotFoundException(String message, String name) {
        super(message);
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }
    public String getMessage() {
        return message;
    }
}
