package com.skilldistillery.learningresource.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.learningresource.entities.Textbook;

@Transactional
@Service
public class LearningResourceDAOImpl implements LearningResourceDAO {

	@PersistenceContext
	private EntityManager em;
	

//////// CREATE
	@Override
	public Textbook create(Textbook textbook) {

		em.persist(textbook);

		return textbook;
	}

//////// READ
	@Override
	public Textbook findById(int id) {
		return em.find(Textbook.class, id);
	}
	
	@Override
	public List<Textbook> findAll() {
		String queryFindAll = "SELECT t FROM Textbook t";
		List<Textbook> allTextbooks = null;
		
		allTextbooks = em.createQuery(queryFindAll, Textbook.class).getResultList();
		return allTextbooks;
	}

//////// UPDATE
	@Override
	public Textbook update(int id, Textbook textbook) {
		Textbook dbTextbook = em.find(Textbook.class, id);

		dbTextbook.setAuthor(textbook.getAuthor());
		dbTextbook.setTitle(textbook.getTitle());
		dbTextbook.setSubtitle(textbook.getSubtitle());
		dbTextbook.setEdition(textbook.getEdition());
		dbTextbook.setYear(textbook.getYear());
		dbTextbook.setLength(textbook.getLength());

		return dbTextbook;
	}

	
//////// DESTROY
	@Override
	public boolean delete(int id) {
		Textbook garbageTextbook = em.find(Textbook.class, id);

		em.remove(garbageTextbook);
		boolean textbookWasDeleted = !em.contains(garbageTextbook);
	
		return textbookWasDeleted;
	}
}
