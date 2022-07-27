package com.informatorio.news_search.dto.article;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

public class ArticleBaseDTO {
    private Long id;
    @NotBlank(message = "titulo vacio")
    private String title;
    @NotBlank(message = "descripcion vacia")
    private String description;
    @Pattern(
        regexp = "^https*://\\w+\\.\\w+.+", 
        message = "url debe comenzar con https://dominio.algo"
    )
    private String url;
    @Pattern(
        regexp = "^https*://\\w+\\.\\w+.+(\\.png|\\.jpg|\\.gif|\\.svg)$", 
        message = "imagen debe cumplir formato de url y terminar con .png|.jpg|.gif|.svg"
    )
    private String urlToImage;
    @NotBlank(message = "contenido vacio")
    private String content;
    @PastOrPresent(message = "fecha invalida")
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
