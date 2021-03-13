package com.skilldistillery.learningresource.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.learningresource.data.LearningResourceDAO;

@Controller
public class LearningResourceController {

	@Autowired
	private LearningResourceDAO dao;
	
	@RequestMapping(path= {"/", "home.do"})
	public String index(Model model) {
		model.addAttribute("test", dao.findById(1)); // TODO this is a DEBUG, remove later
		return "index";
	}
}
