package com.informatorio.news_search.controller;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.news_search.dto.author.AuthorDTO;
import com.informatorio.news_search.dto.author.AuthorPageDTO;
import com.informatorio.news_search.dto.author.AuthorQueryDTO;
import com.informatorio.news_search.service.AuthorService;

@RestController
@RequestMapping(value = "/authors")
@Validated
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping({""})
    @ResponseStatus(HttpStatus.OK)
    public AuthorPageDTO allAuthors(
        @RequestParam(required = false) @Size(min = 3) String query, 
        // @RequestParam(required = false) @NotBlank String date,
        @RequestParam @Positive Integer page, 
        @RequestParam @Positive Integer size
    ) {
        if(query != null) {
            return authorService.getBy(query, page, size);
        }
        return authorService.getAll(page, size);
    }

    @PostMapping(value = {""})
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthor(@RequestBody @Valid AuthorQueryDTO authorQueryDTO) {
        authorService.create(authorQueryDTO);
    }

    @GetMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO getAuthor(@PathVariable Long id) {
        return authorService.get(id);
    }

    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
    }

    @PutMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void modifyAuthor(@PathVariable Long id, @RequestBody @Valid AuthorQueryDTO authorQueryDTO) {
        authorService.modify(id, authorQueryDTO);
    }
}
