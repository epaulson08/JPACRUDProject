package com.skilldistillery.learningresource.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.learningresource.entities.Author;
import com.skilldistillery.learningresource.entities.Textbook;

@Transactional
@Service
public class LearningResourceDAOImpl implements LearningResourceDAO {

	@PersistenceContext
	private EntityManager em;

//////// CREATE
	@Override
	public Textbook createTextbook(Textbook textbook) {

		em.persist(textbook);

		return textbook;
	}

	@Override
	public Author createAuthor(Author author) {
		
		em.persist(author);
		
		return author;
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

	@Override
	public List<Textbook> findByTitle(String title) {
		List<Textbook> textbookList = null;
		title = "%" + title + "%";
		
		String queryFindByTitle = "SELECT t FROM Textbook t WHERE t.title LIKE :bindVar";
		textbookList = em.createQuery(queryFindByTitle, Textbook.class).setParameter("bindVar", title).getResultList();
		return textbookList;
	}

//	Deprecated when changed `author` to `authors`:
//	@Override
//	public List<Textbook> findByAuthor(String author) {
//		List<Textbook> textbookList = null;
//		author = "%" + author + "%";
//		
//		String queryFindByAuthor = "SELECT t FROM Textbook t WHERE t.author LIKE :bindVar";
//		textbookList = em.createQuery(queryFindByAuthor, Textbook.class).setParameter("bindVar", author).getResultList();
//		return textbookList;
//	}
	
//////// UPDATE
	// TODO: update to reflect `author` vs. `authors`
	@Override
	public Textbook updateTextbook(int id, Textbook textbook) {
		Textbook dbTextbook = em.find(Textbook.class, id);

		if (textbook.getAuthors().size() != 0 && textbook.getAuthors() != null)
			dbTextbook.setAuthors(textbook.getAuthors());

		if (textbook.getTitle() != "" && textbook.getTitle() != null)
			dbTextbook.setTitle(textbook.getTitle());

		if (textbook.getSubtitle() != "" && textbook.getSubtitle() != null)
			dbTextbook.setSubtitle(textbook.getSubtitle());

		if (textbook.getEdition() != null)
			dbTextbook.setEdition(textbook.getEdition());

		if (textbook.getYear() != null)
			dbTextbook.setYear(textbook.getYear());

		if (textbook.getLength() != null)
			dbTextbook.setLength(textbook.getLength());

		return dbTextbook;
	}
	
	public void addAuthorToTextbook(int textbookId, Author author) {
		Textbook dbTextbook = em.find(Textbook.class, textbookId);
		dbTextbook.addAuthor(author);		
	}

//////// DESTROY
	@Override
	public Textbook delete(int id) {
		Textbook garbageTextbook = em.find(Textbook.class, id);

		em.remove(garbageTextbook);
		boolean textbookWasDeleted = !em.contains(garbageTextbook);

		if (!textbookWasDeleted)
			return null;
		else
			return garbageTextbook;
	}
}
