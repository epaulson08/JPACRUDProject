package com.skilldistillery.learningresource.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.learningresource.data.LearningResourceDAO;
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

//////// CREATE

	@RequestMapping(path = "recordCreated.do", method = RequestMethod.POST)
	public ModelAndView recordCreated(String author, String title, String subtitle, String edition, String year,
			String length) {
		ModelAndView mv = new ModelAndView();
		Integer checkedEdition = null, checkedYear = null, checkedLength = null;
		try {
			if (edition != "")
				checkedEdition = Integer.parseInt(edition);
			if (year != "")
				checkedYear = Integer.parseInt(year);
			if (length != "")
				checkedLength = Integer.parseInt(length);

			Textbook textbook = new Textbook(author, title, subtitle, checkedEdition, checkedYear, checkedLength);
			mv.addObject("textbook", dao.create(textbook));
			mv.setViewName("recordCreated");
			return mv;

		} catch (Exception e) {
			mv.setViewName("inputError");
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

	@RequestMapping(path = "searchByAuthor.do", method = RequestMethod.GET)
	public ModelAndView searchByAuthor(String author) {
		ModelAndView mv = new ModelAndView();
		List<Textbook> textbooks = dao.findByAuthor(author);
		if (textbooks != null) {
			mv.addObject("textbooks", textbooks);
			mv.setViewName("viewRecords");
		} else {
			mv.setViewName("noneFound");
		}
		return mv;
	}

//////// UPDATE
	@RequestMapping(path = "recordUpdated.do", method = RequestMethod.POST)
	public ModelAndView recordUpdated(int id, String author, String title, String subtitle, String edition, String year,
			String length) {
		ModelAndView mv = new ModelAndView();
		Integer checkedEdition = null, checkedYear = null, checkedLength = null;

		try {

			if (edition != "")
				checkedEdition = Integer.parseInt(edition);
			if (year != "")
				checkedYear = Integer.parseInt(year);
			if (length != "")
				checkedLength = Integer.parseInt(length);

			Textbook textbook = new Textbook(author, title, subtitle, checkedEdition, checkedYear, checkedLength);
			mv.addObject("textbook", dao.update(id, textbook));

			mv.setViewName("recordUpdated");
			return mv;

		} catch (Exception e) {
			mv.setViewName("inputError");
			return mv;
		}
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

}
