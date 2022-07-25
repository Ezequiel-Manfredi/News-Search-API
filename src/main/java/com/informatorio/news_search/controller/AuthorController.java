package com.informatorio.news_search.controller;

import java.util.List;

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

import com.informatorio.news_search.dto.author.AuthorDTO;
import com.informatorio.news_search.dto.author.AuthorQueryDTO;
import com.informatorio.news_search.service.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping({""})
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDTO> allAuthors() {
        return authorService.getAll();
    }

    @PostMapping(value = {""})
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthor(@RequestBody AuthorQueryDTO authorQueryDTO) {
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
    public void modifyAuthor(@PathVariable Long id, @RequestBody AuthorQueryDTO authorQueryDTO) {
        authorService.modify(id, authorQueryDTO);
    }
}
