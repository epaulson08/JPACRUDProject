package com.skilldistillery.learningresource.data;

import java.util.List;

import com.skilldistillery.learningresource.entities.Author;
import com.skilldistillery.learningresource.entities.Textbook;

public interface TextbookDAO {

	// CREATE
	public Textbook create(Textbook textbook);

	// READ
	Textbook findById(int id);
	List<Textbook> findAll();
	List<Textbook> findByTitle(String title);
	List<Textbook> findByAuthor(Author author);

	//  Deprecated when changed `author` to `authors`
	//	List<Textbook> findByAuthor(String author);
	
	// UPDATE
	public Textbook update(int id, Textbook textbook);
	public void addAuthorToTextbook(int textbookId, Author author);
	
	// DELETE	
	public Textbook delete(int id);
	
}
