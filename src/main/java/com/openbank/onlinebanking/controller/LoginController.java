package com.openbank.onlinebanking.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.blo.impl.LoginServiceImpl;
import com.openbank.onlinebanking.form.LoginForm;

@Controller
@SessionAttributes
public class LoginController {

	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") LoginForm loginForm, BindingResult result, Map model) {
		
		String forward = "login";
		LoginService service = new LoginServiceImpl();
		boolean isLoginSuccess = service.login(loginForm);
		
		if (isLoginSuccess) {
			forward = "loginsuccess";
		}
		model.put("loginForm", loginForm);
		return forward;
	}
	
	@RequestMapping("/login")
	public ModelAndView showContacts() {
		return new ModelAndView("login", "command", new LoginForm());
	}
}