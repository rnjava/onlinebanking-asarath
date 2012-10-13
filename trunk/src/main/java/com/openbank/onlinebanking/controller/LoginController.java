package com.openbank.onlinebanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.form.LoginForm;

@Controller
@SessionAttributes
public class LoginController {

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("login")
							LoginForm loginForm, BindingResult result) {
		System.out.println("Inside addContact");
		
		System.out.println("First Name:" +loginForm.getUserName());
		return "redirect:login";
	}
	
	@RequestMapping("/login")
	public ModelAndView showContacts() {
		System.out.println("Inside Show contacts");
		
		return new ModelAndView("login", "command", new LoginForm());
	}
}