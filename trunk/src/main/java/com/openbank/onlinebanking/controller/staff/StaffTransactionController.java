package com.openbank.onlinebanking.controller.staff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.form.staff.CreateAccountForm;

@Controller
public class StaffTransactionController {
	
	private static Logger log = LoggerFactory.getLogger(StaffTransactionController.class);
	
	@RequestMapping(value="/staffdeposit",  method=RequestMethod.GET)
	public ModelAndView createAccountFormLoad(@RequestParam(value = "tenantid") String tenantId, 
			@RequestParam(value = "profileid") String profileId, 
			@RequestParam(value = "accountNo") String accountNo) {

		log.debug("Entering....");
		CreateAccountForm createAccountForm = new CreateAccountForm();
		createAccountForm.setTenantId(tenantId);
		createAccountForm.setStaffProfileId(profileId);
		ModelAndView modelAndView = new ModelAndView("staffcreateaccount");
		modelAndView.addObject("form", createAccountForm);
		log.debug("Existing..........");
		return modelAndView;
	}

}
