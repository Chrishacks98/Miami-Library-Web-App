package com.henrybooks.controller;

import com.henrybooks.model.Author;
import com.henrybooks.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepo;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable(value = "id") BigInteger authorNum) {
        Author author = authorRepo.findOne(authorNum);
        if (author == null){
            author.setAuthorNum(new BigInteger("-1"));
        }
        return author;
    }
}
