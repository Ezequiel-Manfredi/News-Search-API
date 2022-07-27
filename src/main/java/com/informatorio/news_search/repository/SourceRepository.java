package com.informatorio.news_search.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.informatorio.news_search.model.SourceModel;

public interface SourceRepository extends PagingAndSortingRepository<SourceModel,Long> {
    
}
