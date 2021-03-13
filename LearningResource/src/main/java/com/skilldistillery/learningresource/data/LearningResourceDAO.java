package com.skilldistillery.learningresource.data;

import java.util.List;

import com.skilldistillery.learningresource.entities.Textbook;

public interface LearningResourceDAO {

	// CREATE
	public Textbook create(Textbook textbook);

	// READ
	Textbook findById(int id);
	List<Textbook> findAll();
	
	// UPDATE
	public Textbook update(int id, Textbook textbook);
	
	// DELETE	
	public boolean delete(int id);
	
	
		
}
