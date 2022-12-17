package com.demo.service;

import com.demo.entity.Author;
import com.demo.entity.Registration;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);
    Author findByAuthorId(int id);
    List<Author> findAll();
}
