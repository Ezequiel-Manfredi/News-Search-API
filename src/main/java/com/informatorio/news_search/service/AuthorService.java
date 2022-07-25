package com.informatorio.news_search.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatorio.news_search.converter.ArticleConverter;
import com.informatorio.news_search.converter.AuthorConverter;
import com.informatorio.news_search.dto.author.AuthorDTO;
import com.informatorio.news_search.dto.author.AuthorQueryDTO;
import com.informatorio.news_search.exception.AuthorNotFoundException;
import com.informatorio.news_search.model.AuthorModel;
import com.informatorio.news_search.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthorConverter authorConverter;
    @Autowired
    ArticleConverter articleConverter;

    public List<AuthorDTO> getAll() {
        return authorRepository
            .findAll()
            .stream()
            .map(authorModel -> authorConverter.toDTO(
                authorModel, 
                authorModel
                    .getArticles()
                    .stream()
                    .map(articleModel -> articleConverter.toBaseDTO(articleModel))
                    .collect(Collectors.toList())
            ))
            .collect(Collectors.toList());
    }

    public void create(AuthorQueryDTO authorQueryDTO) {
        AuthorModel authorModel = authorConverter.toModel(authorQueryDTO);
        authorRepository.save(authorModel);
    }

    public AuthorDTO get(Long id) {
        Optional<AuthorModel> authorModel = authorRepository.findById(id);
        if(authorModel.isPresent()) {
            return authorConverter.toDTO(
                authorModel.get(), 
                authorModel.get()
                    .getArticles()
                    .stream()
                    .map(articleModel -> articleConverter.toBaseDTO(articleModel))
                    .collect(Collectors.toList()
            ));
        } else {
            throw new AuthorNotFoundException("autor no encontrado");
        }
    }

    public void delete(Long id) {
        Optional<AuthorModel> authorModel = authorRepository.findById(id);
        if(authorModel.isPresent()) {
            authorRepository.delete(authorModel.get());
        } else {
            throw new AuthorNotFoundException("autor no encontrado");
        }
    }

    public void modify(Long id, AuthorQueryDTO authorQueryDTO) {
        Optional<AuthorModel> authorModel = authorRepository.findById(id);
        if(authorModel.isPresent()) {
            AuthorModel authorToModify = authorModel.get();
            authorToModify.setFirstName(authorQueryDTO.getFirstName());
            authorToModify.setLastName(authorQueryDTO.getLastName());
            authorRepository.save(authorToModify);
        } else {
            throw new AuthorNotFoundException("autor no encontrado");
        }
    }
}
