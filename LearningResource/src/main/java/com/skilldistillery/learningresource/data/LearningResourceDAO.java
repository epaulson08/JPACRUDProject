package com.skilldistillery.learningresource.data;

import java.util.List;

import com.skilldistillery.learningresource.entities.Author;
import com.skilldistillery.learningresource.entities.Textbook;

public interface LearningResourceDAO {

	// CREATE
	public Textbook createTextbook(Textbook textbook);
	public Author createAuthor(Author author);

	// READ
	Textbook findById(int id);
	List<Textbook> findAll();
	List<Textbook> findByTitle(String title);

	//  Deprecated when changed `author` to `authors`
	//	List<Textbook> findByAuthor(String author);
	
	// UPDATE
	public Textbook updateTextbook(int id, Textbook textbook);
	public void addAuthorToTextbook(int textbookId, Author author);
	
	// DELETE	
	public Textbook delete(int id);
	
	
		
}
