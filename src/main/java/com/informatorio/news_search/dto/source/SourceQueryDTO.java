package com.informatorio.news_search.dto.source;

public class SourceQueryDTO {
    private Long id;
    private String name;

    public SourceQueryDTO() {}
    public SourceQueryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
