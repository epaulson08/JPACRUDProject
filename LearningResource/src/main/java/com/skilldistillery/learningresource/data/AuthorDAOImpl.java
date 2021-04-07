package com.skilldistillery.learningresource.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.learningresource.entities.Author;

@Transactional
@Service
public class AuthorDAOImpl implements AuthorDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Author create(Author author) {
		em.persist(author);
		return author;
	}
	
	@Override
	public List<Author> findAll() {
		
		String queryFindAll = "SELECT a FROM Author a";
		List<Author> allAuthors = null;
		allAuthors = em.createQuery(queryFindAll, Author.class).getResultList();
		return allAuthors;
	}

}
