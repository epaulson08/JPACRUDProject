package com.skilldistillery.learningresource.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		t = em.find(Textbook.class, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		t = null;
	}

	@Test
	void test_Textbook_entity_mapping() {
		assertNotNull(t);
		assertEquals(2, t.getId());
		assertEquals("Herbert Schildt", t.getAuthor());
		assertEquals("Java A Beginner's Guide", t.getTitle());
		assertEquals("Create, Compile, and Run Java Programs Today", t.getSubtitle());
		assertEquals(8, t.getEdition());
		assertEquals(2019, t.getYear());
		assertEquals(684, t.getLength());
	}
	
	

}
