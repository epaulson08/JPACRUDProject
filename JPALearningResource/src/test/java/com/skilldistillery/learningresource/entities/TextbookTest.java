package com.skilldistillery.learningresource.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextbookTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Textbook t;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	emf = Persistence.createEntityManagerFactory("LearningResource");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		t = em.find(Textbook.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		t = null;
	}

	@Test
	void test_Textbook_entity_mapping() {
		assertNotNull(t);
		assertEquals("Great Book", t.getTitle());
		
	}

}
