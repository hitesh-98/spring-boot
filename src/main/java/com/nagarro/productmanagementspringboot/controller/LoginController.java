package com.nagarro.productmanagementspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.productmanagementspringboot.business.LoginService;
import com.nagarro.productmanagementspringboot.models.LoginForm;


@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/")
	public String showForm(Model model) {
		return "login";
	}

	@RequestMapping(path = "/processLogin", method = RequestMethod.POST)
	public String validate(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {

		if (this.loginService.validateUser(loginForm)) {
			return "home";
		} else {
			return "error";
		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {
		return "login";
	}
	
	@RequestMapping(path = "/retry", method = RequestMethod.POST)
	public String retry(Model model) {
		return "login";
	}

}
