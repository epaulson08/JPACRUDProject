package com.skilldistillery.learningresource.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.learningresource.entities.Textbook;

@Service
@Transactional
public class LearningResourceDAOImpl implements LearningResourceDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Textbook findById(int id) {
		return em.find(Textbook.class, id);
	}

	@Override
	public List<Textbook> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
