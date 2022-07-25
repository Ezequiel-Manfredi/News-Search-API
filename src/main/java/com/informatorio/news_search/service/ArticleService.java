package com.informatorio.news_search.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatorio.news_search.converter.ArticleConverter;
import com.informatorio.news_search.dto.article.ArticleDTO;
import com.informatorio.news_search.dto.article.ArticleQueryDTO;
import com.informatorio.news_search.model.ArticleModel;
import com.informatorio.news_search.model.AuthorModel;
import com.informatorio.news_search.model.SourceModel;
import com.informatorio.news_search.repository.ArticleRepository;
import com.informatorio.news_search.repository.AuthorRepository;
import com.informatorio.news_search.repository.SourceRepository;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleConverter articleConverter;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    SourceRepository sourceRepository;
    
    public List<ArticleDTO> getAll() {
        return articleRepository
            .findAll()
            .stream()
            .map(articleModel -> articleConverter.toDTO(articleModel))
            .collect(Collectors.toList());
    }

    public void create(ArticleQueryDTO articleQueryDTO) {
        Optional<AuthorModel> authorModel = authorRepository
            .findById(articleQueryDTO.getAuthor().getId());
        if(!authorModel.isPresent()) {
            // throw new AuthorNotFoundException("autor no encontrado");
        }
        Optional<SourceModel> sourceModel = sourceRepository
            .findById(articleQueryDTO.getSource().getId());
        if(!sourceModel.isPresent()) {
            // throw new SourceNotFoundException("fuente no encontrada");
        }
        
        ArticleModel articleModel = articleConverter
            .toModel(articleQueryDTO, authorModel.get(), sourceModel.get());
        articleRepository.save(articleModel);
    }

    public ArticleDTO get(Long id) {
        Optional<ArticleModel> articleModel = articleRepository.findById(id);
        if(articleModel.isPresent()) {
            return articleConverter.toDTO(articleModel.get());
        } else {
            return null;// throw new ArticleNotFoundException("articulo no encontrado");
        }
    }

    public void delete(Long id) {
        Optional<ArticleModel> articleModel = articleRepository.findById(id);
        if(articleModel.isPresent()) {
            articleRepository.delete(articleModel.get());
        } else {
            // throw new ArticleNotFoundException("articulo no encontrado");
        }
    }

    // MEJORAR ESTO 
    public void modify(Long id, ArticleQueryDTO articleQueryDTO) {
        Optional<ArticleModel> articleModel = articleRepository.findById(id);
        if(articleModel.isPresent()) {
            ArticleModel articleToModify = articleModel.get();
            articleToModify.setTitle(articleQueryDTO.getTitle());
            articleToModify.setDescription(articleQueryDTO.getDescription());
            articleToModify.setUrl(articleQueryDTO.getUrl());
            articleToModify.setUrlToImage(articleQueryDTO.getUrlToImage());
            articleToModify.setContent(articleQueryDTO.getContent());
            articleToModify.setPublishedAt(articleQueryDTO.getPublishedAt());
            if(articleToModify.getAuthor().getId() != articleQueryDTO.getAuthor().getId()) {
                Optional<AuthorModel> authorModel = authorRepository
                    .findById(articleQueryDTO.getAuthor().getId());
                if(authorModel.isPresent()) {
                    articleToModify.setAuthor(authorModel.get());
                } else {
                    // throw new AuthorNotFoundException("autor no encontrado");
                }
            }
            if(articleToModify.getSource().getId() != articleQueryDTO.getSource().getId()) {
                Optional<SourceModel> sourceModel = sourceRepository
                    .findById(articleQueryDTO.getSource().getId());
                if(sourceModel.isPresent()) {
                    articleToModify.setSource(sourceModel.get());
                } else {
                    // throw new SourceNotFoundException("fuente no encontrada");
                }
            }
            articleRepository.save(articleToModify);
        } else {
            // throw new ArticleNotFoundException("articulo no encontrado");
        }
    }
}
