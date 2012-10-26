package com.openbank.onlinebanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransferController {
	
	@RequestMapping(value="/maketransfer", method=RequestMethod.GET)
	public ModelAndView makeTransfer() {
		ModelAndView modelAndView = new ModelAndView("maketransfer");
		//modelAndView.addObject("form", form);
		return modelAndView;
	}

	@RequestMapping(value="/addrecipient", method=RequestMethod.GET)
	public ModelAndView addRecipient() {
					
				ModelAndView modelAndView = new ModelAndView("addrecipient");
				//modelAndView.addObject("form", form);
				return modelAndView;
		}

	
	
}
