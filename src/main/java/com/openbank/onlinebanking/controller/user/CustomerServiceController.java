package com.openbank.onlinebanking.controller.user;

import static com.openbank.onlinebanking.util.ApplicationConstants.STAFF_ADMIN_ROLE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.dto.Role;
import com.openbank.onlinebanking.dto.User;
import com.openbank.onlinebanking.form.ChangePasswordForm;

@Controller
public class CustomerServiceController {
	
	private LoginService loginService;
	
	private static Logger log = LoggerFactory.getLogger(CustomerServiceController.class);
	
	/**
	 * Change Password page load for staff
	 * 
	 * @param tenantId
	 * @param profileId
	 * @return
	 */
	
	@RequestMapping(value="/userchangepassword",  method=RequestMethod.GET)
	public ModelAndView changePassword(@RequestParam(value = "tenantid") String tenantId, @RequestParam(value = "profileid") String profileId ) {

		log.debug("Entering....");
		ChangePasswordForm form = new ChangePasswordForm();
		ModelAndView modelAndView = new ModelAndView("userchangepassword");
		form.setTenantId(tenantId);
		form.setStaffProfileId(profileId);
		User user = loginService.getUserByProfileId(form.getTenantId(), form.getStaffProfileId());
		if(user != null && user.getRole() != null) {
			Role role = user.getRole();
			if(STAFF_ADMIN_ROLE.equals(role.getSecondary())) {
				modelAndView.addObject("role", STAFF_ADMIN_ROLE);
			}
		}
		modelAndView.addObject("form", form);
		log.debug("Existing..........");
		return modelAndView;
	}
	

	
	@RequestMapping(value="/userchangepasswordsubmit",  method=RequestMethod.POST)
	public ModelAndView changePasswordSubmit(@ModelAttribute("form") ChangePasswordForm form, BindingResult result) {

		log.debug("Entering ....");
		ModelAndView modelAndView = new ModelAndView("userchangepassword");
		
		validateChangePassword(form, result);
		
		if(!result.hasErrors()) {
			if(form.getNewPassword().equals(form.getNewPasswordRep())) {
				User user = loginService.getUserByProfileId(form.getTenantId(), form.getStaffProfileId());
				if(user != null && form.getCurrentPassword().equals(user.getPassword())) {
					user.setPassword(form.getNewPassword());
					loginService.updateUser(user);
					modelAndView.addObject("successMessage", "Password changed successfully !!!");
				} else {
					result.addError(new ObjectError("currentPassword", "Current password is wrong"));
				}
				
			} else {
				result.addError(new ObjectError("newPassword", "New password doesn't match"));
			}
		}
		modelAndView.addObject("form", form);
		log.debug("Existing..........");
		return modelAndView;

	}
	
	public void validateChangePassword(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "","Enter the current password");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "", "Enter the new password");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPasswordRep", "", "Re-enter the new password");
	}



	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	
}
