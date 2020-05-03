package com.java.last.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.last.project.annotion.MethodRunningTime;
import com.java.last.project.dao.AuthorRepository;
import com.java.last.project.model.Authors;
import com.java.last.project.model.Book;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@MethodRunningTime(active = true)
	@Override
	@Transactional
	public void saveAuthor(Authors author) {
		// TODO Auto-generated method stub
		authorRepository.save(author);
	}

	@MethodRunningTime(active = true)
	@Override
	@Transactional
	public void updateAuthor(Authors author, int authorId) {
		// TODO Auto-generated method stub
		Authors temp = authorRepository.findById(authorId);
		temp = author;
		authorRepository.save(temp);
	}

	@MethodRunningTime(active = true)
	@Override
	@Transactional
	public void deleteAuthor(int authorId) {
		// TODO Auto-generated method stub
		authorRepository.deleteById(authorId);
	}

	@MethodRunningTime(active = true)
	@Override
	public List<Authors> getAll() {
		// TODO Auto-generated method stub
		return authorRepository.listAllAuthor();
	}

	@Override
	public Authors findByAuthorId(int authorId) {
		// TODO Auto-generated method stub
		return authorRepository.findById(authorId);
		
	}

}
