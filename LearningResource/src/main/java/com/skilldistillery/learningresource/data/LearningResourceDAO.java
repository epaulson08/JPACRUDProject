package com.skilldistillery.learningresource.data;

import java.util.List;

import com.skilldistillery.learningresource.entities.Textbook;

public interface LearningResourceDAO {

	// CREATE
	public Textbook create(Textbook textbook);

	// READ
	Textbook findById(int id);
	List<Textbook> findAll();
	List<Textbook> findByTitle(String title);

	//  Deprecated when changed `author` to `authors`
	//	List<Textbook> findByAuthor(String author);
	
	// UPDATE
	public Textbook update(int id, Textbook textbook);
	
	// DELETE	
	public Textbook delete(int id);
	
	
		
}
