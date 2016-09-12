package com.sf.mvc.orm.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@RequestMapping(method = RequestMethod.GET)
	public String defaultView(Model model){
		model.addAttribute("serverTime", new Date());
		return "view";
	}
}
