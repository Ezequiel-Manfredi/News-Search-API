package com.informatorio.news_search.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.news_search.dto.source.SourceDTO;
import com.informatorio.news_search.dto.source.SourceQueryDTO;
import com.informatorio.news_search.service.SourceService;

@RestController
@RequestMapping(value = "/sources")
public class SourceController {
    @Autowired
    SourceService sourceService;

    @GetMapping(value = {""})
    @ResponseStatus(HttpStatus.OK)
    public List<SourceDTO> allSource() {
        return sourceService.getAll();
    }

    @PostMapping(value = {""})
    @ResponseStatus(HttpStatus.CREATED)
    public void createSource(@RequestBody @Valid SourceQueryDTO sourceQueryDTO) {
        sourceService.create(sourceQueryDTO);
    }

    @GetMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public SourceDTO getSource(@PathVariable Long id) {
        return sourceService.get(id);
    }

    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteSource(@PathVariable Long id) {
        sourceService.delete(id);
    }

    @PutMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void modifySource(@PathVariable Long id, @RequestBody @Valid SourceQueryDTO sourceQueryDTO) {
        sourceService.modify(id, sourceQueryDTO);
    }
}
