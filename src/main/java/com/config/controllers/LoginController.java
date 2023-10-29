package com.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String loginPage() {
//		System.out.println("Home Page");
//		return "Register";
//	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String welcomePage(ModelMap model, @RequestParam String username, @RequestParam String password) {
		if(username.equals("Neha") && password.equals("neha@222")) {
			return "Welcome";
		}
		model.put("errorMsg", "Please Provide the correct userId and password");
		return "Register";
	}	
}