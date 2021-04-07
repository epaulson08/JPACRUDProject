package com.skilldistillery.learningresource.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Author author;

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
		author = em.find(Author.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		author = null;
	}

	@Test
	void test_Author_entity_mapping() {
		assertNotNull(author);
		assertEquals("Herbert", author.getFirstName());
		assertEquals("Schildt", author.getLastName());

/* 
mysql> SELECT * FROM author WHERE id = 1;
+----+------------+-------------+-----------+--------+
| id | first_name | middle_name | last_name | suffix |
+----+------------+-------------+-----------+--------+
|  1 | Herbert    | NULL        | Schildt   | NULL   |
+----+------------+-------------+-----------+--------+
1 row in set (0.00 sec)
*/
	}
	
	@Test
	void test_Author_to_Textbook_mapping() {
		assertNotNull(author);
		assertNotNull(author.getTextbooks());
		assertTrue(author.getTextbooks().size() > 0);
/*
mysql> SELECT * FROM author JOIN author_textbook ON author.id = author_textbook.author_id JOIN textbook ON textbook.id = author_textbook.textbook_id WHERE textbook.id = 3;
+----+------------+-------------+-----------+--------+-----------+-------------+----+-----------------+------------------------+----------------------------------------------+---------+------+--------+
| id | first_name | middle_name | last_name | suffix | author_id | textbook_id | id | author          | title                  | subtitle                                     | edition | year | length |
+----+------------+-------------+-----------+--------+-----------+-------------+----+-----------------+------------------------+----------------------------------------------+---------+------+--------+
|  1 | Herbert    | NULL        | Schildt   | NULL   |         1 |           3 |  3 | Herbert Schildt | Java A Beginners Guide | Create, Compile, and Run Java Programs Today |       8 | 2019 |    684 |
+----+------------+-------------+-----------+--------+-----------+-------------+----+-----------------+------------------------+----------------------------------------------+---------+------+--------+
1 row in set (0.00 sec)
*/
	}

}
