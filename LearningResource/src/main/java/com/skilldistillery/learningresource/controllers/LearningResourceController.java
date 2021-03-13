package com.skilldistillery.learningresource.controllers;

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
	
	@RequestMapping(path = "enterSearchRecordByID.do")
	public String goToSearchIDPage() {
		return "searchRecordByID";
	}
	
	@RequestMapping(path = "createRecord.do", method = RequestMethod.GET)
	public String createRecord() {
		return "createRecord";
	}
	
//////// CREATE

	@RequestMapping(path = "recordCreated.do", method = RequestMethod.POST)
	public ModelAndView recordCreated(String author, String title, String subtitle, Integer edition, Integer year, Integer length ) {
		ModelAndView mv = new ModelAndView();
		Textbook textbook = new Textbook(author, title, subtitle, edition, year, length);
		mv.addObject("textbook", dao.create(textbook));
		mv.setViewName("recordCreated");
		return mv;		
	}

//////// READ
	@RequestMapping(path = "searchRecordByID.do", method = RequestMethod.GET)
	public ModelAndView searchRecordByID(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("textbook", dao.findById(id));
		mv.setViewName("viewRecord");
		return mv;
	}
	
	// TODO search by keyword
	// TODO search by title
	// TODO search by author
	
//////// UPDATE
	// TODO update
	
//////// DELETE
	// TODO delete

}
