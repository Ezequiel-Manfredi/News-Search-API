package com.informatorio.news_search.dto.author;

public class AuthorQueryDTO {
    private Long id;
    private String firstName;
    private String lastName;
    
    public AuthorQueryDTO() {}
    public AuthorQueryDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
