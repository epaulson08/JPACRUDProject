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
	@RequestMapping(path = "recordUpdated.do", method = RequestMethod.POST)
	public ModelAndView recordUpdated(int id, String author, String title, String subtitle, Integer edition, Integer year, Integer length ) {
		ModelAndView mv = new ModelAndView();
		Textbook textbook = new Textbook(author, title, subtitle, edition, year, length);
		// TODO BUG Currently this updates the textbook but if the user did not type anything in a field it deletes that field
		// TODO BUG Also the update page does not display the old title.
		mv.addObject("textbook", dao.update(id, textbook));
		mv.setViewName("recordUpdated");
		return mv;		
	}

	// TODO implement
	
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
