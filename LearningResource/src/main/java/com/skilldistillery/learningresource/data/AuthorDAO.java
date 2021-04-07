package com.skilldistillery.learningresource.data;

import java.util.List;

import com.skilldistillery.learningresource.entities.Author;
import com.skilldistillery.learningresource.entities.Textbook;

public interface AuthorDAO {

	// CREATE
	public Author create(Author author);

	// READ
//	Author findById(int id);

	List<Author> findAll();

	// UPDATE
//	public Author update(int id, Author author);

	// DELETE
//	public Author delete(int id);

}
