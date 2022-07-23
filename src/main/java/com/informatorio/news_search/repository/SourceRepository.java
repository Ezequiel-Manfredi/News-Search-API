package com.informatorio.news_search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatorio.news_search.model.SourceModel;

public interface SourceRepository extends JpaRepository<SourceModel,Long> {
    
}
