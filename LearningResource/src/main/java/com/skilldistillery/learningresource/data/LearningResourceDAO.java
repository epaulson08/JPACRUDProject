package com.skilldistillery.learningresource.data;

import java.util.List;

import com.skilldistillery.learningresource.entities.Textbook;

public interface LearningResourceDAO {
	
	Textbook findById(int id);
	
	List<Textbook> findAll();
	
	
		
		
}
