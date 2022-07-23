package com.informatorio.news_search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatorio.news_search.model.ArticleModel;

public interface ArticleRepository extends JpaRepository<ArticleModel,Long> {
    
}
