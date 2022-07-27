package com.informatorio.news_search.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.informatorio.news_search.model.AuthorModel;

public interface AuthorRepository extends PagingAndSortingRepository<AuthorModel,Long> {

}
