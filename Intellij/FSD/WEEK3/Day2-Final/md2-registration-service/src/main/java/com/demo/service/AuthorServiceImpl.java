package com.demo.service;

import com.demo.entity.Author;
import com.demo.entity.Course;
import com.demo.entity.Registration;
import com.demo.repository.AuthorRepository;
import com.demo.repository.CourseRepository;
import com.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements  AuthorService {

	@Autowired
	private AuthorRepository authorRepository;


	@Override
	public Author save(Author author) {
		Author author1=authorRepository.save(author);

		return author1;
	}

	@Override
	public Author findByAuthorId(int id) {
		return authorRepository.findByAuthorId(id);
	}

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

}