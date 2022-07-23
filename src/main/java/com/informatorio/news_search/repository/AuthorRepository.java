package com.informatorio.news_search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatorio.news_search.model.AuthorModel;

public interface AuthorRepository extends JpaRepository<AuthorModel,Long> {

}
