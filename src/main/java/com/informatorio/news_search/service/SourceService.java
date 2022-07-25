package com.informatorio.news_search.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatorio.news_search.converter.ArticleConverter;
import com.informatorio.news_search.converter.SourceConverter;
import com.informatorio.news_search.dto.source.SourceDTO;
import com.informatorio.news_search.dto.source.SourceQueryDTO;
import com.informatorio.news_search.exception.SourceNotFoundException;
import com.informatorio.news_search.model.SourceModel;
import com.informatorio.news_search.repository.SourceRepository;

@Service
public class SourceService {
    @Autowired
    SourceRepository sourceRepository;
    @Autowired
    SourceConverter sourceConverter;
    @Autowired
    ArticleConverter articleConverter;

    public List<SourceDTO> getAll() {
        return sourceRepository
            .findAll()
            .stream()
            .map(sourceModel -> sourceConverter.toDTO(
                sourceModel, 
                sourceModel
                    .getArticles()
                    .stream()
                    .map(articleModel -> articleConverter.toBaseDTO(articleModel))
                    .collect(Collectors.toList())
            ))
            .collect(Collectors.toList());
    }

    public void create(SourceQueryDTO sourceQueryDTO) {
        SourceModel sourceModel = sourceConverter.toModel(sourceQueryDTO);
        sourceRepository.save(sourceModel);
    }

    public SourceDTO get(Long id) {
        Optional<SourceModel> sourceModel = sourceRepository.findById(id);
        if(sourceModel.isPresent()) {
            return sourceConverter.toDTO(
                sourceModel.get(), 
                sourceModel.get()
                    .getArticles()
                    .stream()
                    .map(articleModel -> articleConverter.toBaseDTO(articleModel))
                    .collect(Collectors.toList()
            ));
        } else {
            throw new SourceNotFoundException("fuente no encontrada");
        }
    }

    public void delete(Long id) {
        Optional<SourceModel> sourceModel = sourceRepository.findById(id);
        if(sourceModel.isPresent()) {
            sourceRepository.delete(sourceModel.get());
        } else {
            throw new SourceNotFoundException("fuente no encontrada");
        }
    }

    public void modify(Long id, SourceQueryDTO sourceQueryDTO) {
        Optional<SourceModel> sourceModel = sourceRepository.findById(id);
        if(sourceModel.isPresent()) {
            SourceModel sourceToModify = sourceModel.get();
            sourceToModify.setName(sourceQueryDTO.getName());
            sourceRepository.save(sourceToModify);
        } else {
            throw new SourceNotFoundException("fuente no encontrada");
        }
    }
}
