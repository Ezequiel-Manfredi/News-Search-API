package com.informatorio.news_search.dto.article;

import java.time.LocalDate;

public class ArticleBaseDTO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String content;
    private LocalDate publishedAt;
    
    public ArticleBaseDTO() {}
    public ArticleBaseDTO(
        Long id, String title, String description, 
        String url, String urlToImage, String content,
        LocalDate publishedAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.content = content;
        this.publishedAt = publishedAt;
    }
    
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getUrl() {
        return url;
    }
    public String getUrlToImage() {
        return urlToImage;
    }
    public String getContent() {
        return content;
    }
    public LocalDate getPublishedAt() {
        return publishedAt;
    }
}
