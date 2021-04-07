package com.skilldistillery.learningresource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.learningresource.data.TextbookDAOImpl;
import com.skilldistillery.learningresource.entities.Textbook;

class TextbookDAOImplTest {

	private TextbookDAOImpl textbookDao;
	private Textbook textbook;
	private List<Textbook> textbooks;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	textbookDao = new TextbookDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	textbookDao = null;
	}

//	@Test
//	void test_findById_returns_correct_textbook() {
//		assertNotNull(textbookDao);
//		textbook = textbookDao.findById(3);
//		assertNotNull(textbook);
//		assertEquals(3, textbook.getId());
//		assertEquals("Java A Beginners Guide", textbook.getTitle());
//		assertEquals(8, textbook.getEdition());
/*
 		mysql> select * from textbook where id = 3;
		+----+------------------------+----------------------------------------------+---------+------+--------+
		| id | title                  | subtitle                                     | edition | year | length |
		+----+------------------------+----------------------------------------------+---------+------+--------+
		|  3 | Java A Beginners Guide | Create, Compile, and Run Java Programs Today |       8 | 2019 |    684 |
		+----+------------------------+----------------------------------------------+---------+------+--------+
		1 row in set (0.00 sec)
*/
//	}

//	@Test
//	void test_findAll_returns_list_of_textbooks() {
//		assertNotNull(textbookDao);
//		textbooks = textbookDao.findAll();
//		assertNotNull(textbooks);
//		assertTrue(textbooks.size() > 0);
//	}
	
}
