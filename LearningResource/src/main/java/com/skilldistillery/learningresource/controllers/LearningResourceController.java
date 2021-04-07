package com.skilldistillery.learningresource.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.learningresource.data.LearningResourceDAO;
import com.skilldistillery.learningresource.entities.Author;
import com.skilldistillery.learningresource.entities.Textbook;

@Controller
public class LearningResourceController {

	@Autowired
	private LearningResourceDAO dao;

/////// NAVIGATION
	@RequestMapping(path = { "/", "home.do" })
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(path = "gotoSearchRecordByID.do")
	public String goToSearchID() {
		return "searchRecordByID";
	}

	@RequestMapping(path = "gotoCreateRecord.do", method = RequestMethod.GET)
	public String gotoCreateRecord() {
		return "createRecord";
	}

	@RequestMapping(path = "gotoUpdateRecord.do", method = RequestMethod.GET)
	public ModelAndView gotoUpdateRecord(int id) {
		ModelAndView mv = new ModelAndView();
		Textbook textbook = dao.findById(id);
		mv.addObject("textbook", textbook);
		mv.setViewName("updateRecord");
		return mv;
	}
	
	@RequestMapping(path = "search.do", method = RequestMethod.GET)
	public String search() {
		return "searchRecordByKeyword";
	}

//////// CREATE

	@RequestMapping(path = "recordCreated.do", method = RequestMethod.POST)
	public ModelAndView recordCreated(String author1FirstName, String author1MiddleName, String author1LastName,
			String author1Suffix, String author2FirstName, String author2MiddleName, String author2LastName,
			String author2Suffix, String author3FirstName, String author3MiddleName, String author3LastName,
			String author3Suffix, String author4FirstName, String author4MiddleName, String author4LastName,
			String author4Suffix, String author5FirstName, String author5MiddleName, String author5LastName,
			String author5Suffix, String title, String subtitle, String edition, String year, String length) {

		ModelAndView mv = new ModelAndView();
		Author author1;
		Author author2;
		Author author3;
		Author author4;
		Author author5;
		Integer checkedEdition = null, checkedYear = null, checkedLength = null;

		try {
			// Clean numeric data (possible NumberFormatException):
			if (edition != "")
				checkedEdition = Integer.parseInt(edition);
			if (year != "")
				checkedYear = Integer.parseInt(year);
			if (length != "")
				checkedLength = Integer.parseInt(length);

			Textbook textbook = new Textbook(title, subtitle, checkedEdition, checkedYear, checkedLength);
			textbook = dao.createTextbook(textbook);

			if (author1FirstName != "" || author1MiddleName != "" || author1LastName != "" || author1Suffix != "") {
				author1 = new Author(author1FirstName, author1MiddleName, author1LastName, author1Suffix);
				dao.createAuthor(author1);
				textbook.addAuthor(author1);
				author1.addTextbook(textbook);
			}
			if (author2FirstName != "" || author2MiddleName != "" || author2LastName != "" || author2Suffix != "") {
				author2 = new Author(author2FirstName, author2MiddleName, author2LastName, author2Suffix);
				dao.createAuthor(author2);
				textbook.addAuthor(author2);
				author2.addTextbook(textbook);
			}
			if (author3FirstName != "" || author3MiddleName != "" || author3LastName != "" || author3Suffix != "") {
				author3 = new Author(author3FirstName, author3MiddleName, author3LastName, author3Suffix);
				dao.createAuthor(author3);
				textbook.addAuthor(author3);
				author3.addTextbook(textbook);
			}
			if (author4FirstName != "" || author4MiddleName != "" || author4LastName != "" || author4Suffix != "") {
				author4 = new Author(author4FirstName, author4MiddleName, author4LastName, author4Suffix);
				dao.createAuthor(author4);
				textbook.addAuthor(author4);
				author4.addTextbook(textbook);
			}
			if (author5FirstName != "" || author5MiddleName != "" || author5LastName != "" || author5Suffix != "") {
				author5 = new Author(author5FirstName, author5MiddleName, author5LastName, author5Suffix);
				dao.createAuthor(author5);
				textbook.addAuthor(author5);
				author5.addTextbook(textbook);
			}

			dao.updateTextbook(textbook.getId(), textbook);

			mv.addObject("textbook", textbook);
			mv.setViewName("recordCreated");
			return mv;

		} catch (Exception e) {
			mv.setViewName("inputError");
			e.printStackTrace();
			return mv;
		}
	}

//////// READ
	@RequestMapping(path = "seeAll.do", method = RequestMethod.GET)
	public ModelAndView seeAll() {
		ModelAndView mv = new ModelAndView();
		List<Textbook> allTextbooks = dao.findAll();
		mv.addObject("textbooks", allTextbooks);
		mv.setViewName("viewRecords");
		return mv;
	}

	@RequestMapping(path = "searchRecordByID.do", method = RequestMethod.GET)
	public ModelAndView searchRecordByID(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("textbook", dao.findById(id));
		mv.setViewName("viewRecord");
		return mv;
	}

	@RequestMapping(path = "searchByTitle.do", method = RequestMethod.GET)
	public ModelAndView searchByTitle(String title) {
		ModelAndView mv = new ModelAndView();
		List<Textbook> textbooks = dao.findByTitle(title);
		if (textbooks != null) {
			mv.addObject("textbooks", textbooks);
			mv.setViewName("viewRecords");
		} else {
			mv.setViewName("noneFound");
		}
		return mv;
	}

//	Deprecated when `author` changed to `authors`:
//	@RequestMapping(path = "searchByAuthor.do", method = RequestMethod.GET)
//	public ModelAndView searchByAuthor(String author) {
//		ModelAndView mv = new ModelAndView();
//		List<Textbook> textbooks = dao.findByAuthor(author);
//		if (textbooks != null) {
//			mv.addObject("textbooks", textbooks);
//			mv.setViewName("viewRecords");
//		} else {
//			mv.setViewName("noneFound");
//		}
//		return mv;
//	}

//////// UPDATE

//  TODO: update to reflect change from `author` to `authors`
//	@RequestMapping(path = "recordUpdated.do", method = RequestMethod.POST)
//	public ModelAndView recordUpdated(int id, String author, String title, String subtitle, String edition, String year,
//			String length) {
//		ModelAndView mv = new ModelAndView();
//		Integer checkedEdition = null, checkedYear = null, checkedLength = null;
//
//		try {
//
//			if (edition != "")
//				checkedEdition = Integer.parseInt(edition);
//			if (year != "")
//				checkedYear = Integer.parseInt(year);
//			if (length != "")
//				checkedLength = Integer.parseInt(length);
//
//			Textbook textbook = new Textbook(author, title, subtitle, checkedEdition, checkedYear, checkedLength);
//			mv.addObject("textbook", dao.update(id, textbook));
//
//			mv.setViewName("recordUpdated");
//			return mv;
//
//		} catch (Exception e) {
//			mv.setViewName("inputError");
//			return mv;
//		}
//	}

	@RequestMapping(path = "gotoAddAuthor.do", method = RequestMethod.GET)
	public ModelAndView gotoAddAuthor(int textbookId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("textbookId", textbookId);
		mv.setViewName("addAuthor");
		return mv;
	}

	@RequestMapping(path = "addAuthor.do", method = RequestMethod.POST)
	public ModelAndView addAuthor() {
		ModelAndView mv = new ModelAndView();
		// TODO: implement
		return mv;
	}

//////// DELETE
	@RequestMapping(path = "recordDeleted.do", method = RequestMethod.POST)
	public ModelAndView recordDeleted(int id) {
		ModelAndView mv = new ModelAndView();
		Textbook textbook = dao.findById(id);
		dao.delete(id);
		mv.addObject(textbook);
		mv.setViewName("recordDeleted");
		return mv;
	}

//////// UTILITIES
//	public Author washAuthorData(String firstName, String middleName, String lastName, String suffix) {
//		Author author = new Author();
//		if (firstName != "" && firstName != null) {
//			author.setFirstName(firstName);
//		}
//		if (middleName != "" && middleName != null) {
//			author.setMiddleName(middleName);
//		}
//		if (lastName != "" && lastName != null) {
//			author.setLastName(lastName);
//		}
//		if (suffix != "" && suffix != null) {
//			author.setSuffix(suffix);
//		}
//		return author;
//	}

//	public boolean isEmptyAuthor(Author author) {
//		boolean authorIsEmpty = true;
//
//		if (author.getFirstName() != null && author.getFirstName() != "")
//			authorIsEmpty = false;
//
//		if (author.getMiddleName() != null && author.getMiddleName() != "")
//			authorIsEmpty = false;
//
//		if (author.getLastName() != null && author.getLastName() != "")
//			authorIsEmpty = false;
//
//		if (author.getSuffix() != null && author.getSuffix() != "")
//			authorIsEmpty = false;
//
//		return authorIsEmpty;
//	}

}
