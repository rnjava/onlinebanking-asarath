package com.openbank.onlinebanking.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.blo.impl.LoginServiceImpl;
import com.openbank.onlinebanking.form.LoginForm;

@Controller
//@SessionAttributes
@RequestMapping("login")
public class LoginController {
	
		@RequestMapping(method = RequestMethod.GET)
		public String showForm(Map<String, LoginForm> model) {
			LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			return "login";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String processForm(@Valid LoginForm loginForm, BindingResult result,
				Map<String, LoginForm> model) {
			String forward = "login";
			LoginService service = new LoginServiceImpl();
			boolean isLoginSuccess = service.login(loginForm);
			
			if (isLoginSuccess) {
				//forward = "loginsuccess";
				forward = "accountsoverview";
			} else {
				loginForm = new LoginForm();
			}
			model.put("loginForm", loginForm);
			return forward;
		}

//	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
//	public String login(@ModelAttribute("login") LoginForm loginForm, BindingResult result, Map<String, LoginForm> model) {
//		
//		String forward = "login.html";
//		LoginService service = new LoginServiceImpl();
//		boolean isLoginSuccess = service.login(loginForm);
//		
//		if (isLoginSuccess) {
//			forward = "loginsuccess";
//		}
//		model.put("loginForm", loginForm);
//		return forward;
//	}
//	
//	@RequestMapping("/login")
//	public ModelAndView showContacts() {
//		return new ModelAndView("login", "command", new LoginForm());
//	}
	

//	@RequestMapping(value= "/loginFailure", method = RequestMethod.POST)
//	public String loginPage(@ModelAttribute("login") LoginForm loginForm, BindingResult result, Map<String, LoginForm> model) {
//		model.put("loginForm", new LoginForm());
//		return "login";
//	}

}