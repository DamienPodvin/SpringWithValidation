package com.journaldev.spring.form.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.form.model.Test;
@Controller
public class TestController {

	@Autowired
	@Qualifier("testValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	@RequestMapping(value = "/test/save", method = RequestMethod.GET)
	public String saveTesterPage(Model model) {
		model.addAttribute("test", new Test());
		return "testSave";
	}
	
	@RequestMapping(value = "/test/save.do", method = RequestMethod.POST)
	public String saveTesterAction(
			@ModelAttribute("test") @Validated Test test,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "testSave";
		}	
		model.addAttribute("test",test);
		return "testSaveSuccess";	
		}
	
@RequestMapping("/test")
public String index() {
	return "redirect:/test/save";}
}
