package com.karson.webmagic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginview(ModelMap map) {
	  return "login";

	}
}
