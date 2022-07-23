package com.informatorio.news_search.dto.article;

import java.time.LocalDate;

import com.informatorio.news_search.dto.author.AuthorQueryDTO;
import com.informatorio.news_search.dto.source.SourceQueryDTO;

public class ArticleQueryDTO extends ArticleBaseDTO {
    private AuthorQueryDTO author;
    private SourceQueryDTO source;
    
    public ArticleQueryDTO() {}
    public ArticleQueryDTO(
        Long id, String title, String description, 
        String url, String urlToImage, 
        String content, LocalDate publishedAt, 
        AuthorQueryDTO author, SourceQueryDTO source
    ) {
        super(
            id, title, description, url, 
            urlToImage, content, publishedAt
        );
        this.author = author;
        this.source = source;
    }

    public AuthorQueryDTO getAuthor() {
        return author;
    }
    public SourceQueryDTO getSource() {
        return source;
    }
}
