package com.skilldistillery.learningresource.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.learningresource.data.LearningResourceDAO;

@Controller
public class LearningResourceController {

	@Autowired
	private LearningResourceDAO dao;

	@RequestMapping(path = { "/", "home.do" })
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(path = "enterSearchRecordByID.do")
	public String goToSearchIDPage() {
		return "searchRecordByID";
	}

	@RequestMapping(path = "searchRecordByID.do", method = RequestMethod.GET)
	public ModelAndView searchRecordByID(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("textbook", dao.findById(id));
		mv.setViewName("viewRecord");
		return mv;
	}

	@RequestMapping(path = "createRecord.do", method = RequestMethod.GET)
	public ModelAndView createRecord() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createRecord");
		return mv;
	}

	@RequestMapping(path = "recordCreated.do", method = RequestMethod.POST)
	public ModelAndView recordCreated() {
		ModelAndView mv = new ModelAndView();
		// TODO
		mv.setViewName("recordCreated");
		return mv;
	}
}
