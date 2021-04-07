package com.skilldistillery.learningresource.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.learningresource.data.AuthorDAO;
import com.skilldistillery.learningresource.data.TextbookDAO;
import com.skilldistillery.learningresource.entities.Author;
import com.skilldistillery.learningresource.entities.Textbook;

@Controller
public class LearningResourceController {

	@Autowired
	private TextbookDAO textbookDao;

	@Autowired
	private AuthorDAO authorDao;

	
	@RequestMapping(path = "testPage.do", method=RequestMethod.GET)
	public String testPage() {
		return "testPage";
	}
	
	
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
		Textbook textbook = textbookDao.findById(id);
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
	public ModelAndView recordCreated(Author author, Textbook textbook) {
		ModelAndView mv = new ModelAndView();
		authorDao.create(author);
		textbook.addAuthor(author);
		textbookDao.create(textbook);
		mv.setViewName("recordCreated");
		return mv;
		// FIXME: this will allow creation of duplicate authors
		// TODO: allow creation of multiple authors
	}
			
//////// READ
	@RequestMapping(path = "seeAll.do", method = RequestMethod.GET)
	public ModelAndView seeAllTextbooks() {
		ModelAndView mv = new ModelAndView();
		List<Textbook> allTextbooks = textbookDao.findAll();
		mv.addObject("textbooks", allTextbooks);
		mv.setViewName("viewRecords");
		return mv;
	}

	@RequestMapping(path = "allAuthors.do", method = RequestMethod.GET)
	public ModelAndView seeAllAuthors() {
		ModelAndView mv = new ModelAndView();
		List<Author> allAuthors = authorDao.findAll();
		mv.addObject("authors", allAuthors);
		mv.setViewName("testPage");
		return mv;
	}
	
	@RequestMapping(path = "searchRecordByID.do", method = RequestMethod.GET)
	public ModelAndView searchRecordByID(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("textbook", textbookDao.findById(id));
		mv.setViewName("viewRecord");
		return mv;
	}

	@RequestMapping(path = "searchByTitle.do", method = RequestMethod.GET)
	public ModelAndView searchByTitle(String title) {
		ModelAndView mv = new ModelAndView();
		List<Textbook> textbooks = textbookDao.findByTitle(title);
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
	
//	@RequestMapping(path = "recordUpdated.do", method = RequestMethod.POST)
//	public ModelAndView recordUpdated(int id, Author author, Textbook textbook)
	

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
		Textbook textbook = textbookDao.findById(id);
		textbookDao.delete(id);
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
