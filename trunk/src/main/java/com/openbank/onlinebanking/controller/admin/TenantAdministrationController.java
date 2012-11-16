package com.openbank.onlinebanking.controller.admin;

import java.util.Date;
import java.util.List;

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

import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.blo.TenantService;
import com.openbank.onlinebanking.dto.Profile;
import com.openbank.onlinebanking.dto.Tenant;
import com.openbank.onlinebanking.form.admin.AdministrationForm;
import com.openbank.onlinebanking.util.GuidUtil;

@Controller
public class TenantAdministrationController {

	
	private static Logger log = LoggerFactory.getLogger(TenantAdministrationController.class);
	private ProfileService profileService;
	private TenantService tenantService;
	
	
	
	@RequestMapping(value="/searchtenant",  method=RequestMethod.GET)
	public ModelAndView searchTeanat(@RequestParam(value = "tenantid") String tenantId, @RequestParam(value = "profileid") String staffProfileId ) {

		log.debug("Entering....");
		AdministrationForm administrationForm = new AdministrationForm();
		administrationForm.setTenantId(tenantId);
		administrationForm.setStaffProfileId(staffProfileId);
		ModelAndView modelAndView = new ModelAndView("searchtenant");
		modelAndView.addObject("form", administrationForm);
		log.debug("Existing..........");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/findtenantsubmit",  method=RequestMethod.POST)
	public ModelAndView findTenant(@ModelAttribute("form") AdministrationForm administrationForm, BindingResult result) {
		log.debug("Entering....");
		ModelAndView modelAndView = new ModelAndView("searchtenant");
		if(administrationForm.getSearchName() == null && administrationForm.getSearchTenantId() == null) {
			result.addError(new ObjectError("searchName", "Please enter the Tenant Name or Tenant ID"));
		} else {
			List<Tenant> tenantList = tenantService.findTenant(administrationForm.getSearchName(), administrationForm.getSearchTenantId());
			modelAndView.addObject("tenantList", tenantList);	
			if(tenantList == null || tenantList.isEmpty()) {
				modelAndView.addObject("successMessage", "No Records found");	
			}
		} 
		
		modelAndView.addObject("form", administrationForm);
		log.debug("Existing..........");
		return modelAndView;
	}

	@RequestMapping(value="/adminloginsuccess",  method=RequestMethod.GET)
	public ModelAndView adminLoginSucess(@RequestParam(value = "tenantid") String tenantId, @RequestParam(value = "profileid") String profileId ) {

		log.debug("Entering....");
		AdministrationForm administrationForm = new AdministrationForm();
		administrationForm.setTenantId(tenantId);
		administrationForm.setStaffProfileId(profileId);
		Profile profile = profileService.getProfileById(profileId, tenantId);
		if(profile != null) {
			administrationForm.setStaffProfileId(profile.getProfileId());
			administrationForm.setStaffFirstName(profile.getFirstName());
			administrationForm.setStaffLastName(profile.getLastName());
		}
		ModelAndView modelAndView = new ModelAndView("adminloginsuccess");
		modelAndView.addObject("form", administrationForm);
		log.debug("Existing..........");
		return modelAndView;
	}

	@RequestMapping(value="/addnewtenantsubmit",  method=RequestMethod.POST)
	public ModelAndView createNewTenant(@ModelAttribute("form") AdministrationForm administrationForm, BindingResult result) {

		log.debug("Entering.....");
		ModelAndView modelAndView = new ModelAndView("adminloginsuccess");
		validate(administrationForm, result);
		if (!result.hasErrors()) {
			Tenant tenant = new Tenant();
			String tenantId = GuidUtil.generateGuid();
			tenant.setAddress(administrationForm.getAddress());
			tenant.setCreatedBy(administrationForm.getStaffFirstName() + " " + administrationForm.getStaffLastName());
			tenant.setCreatedDate(new Date());
			tenant.setEmailAddress(administrationForm.getEmailAddress());
			tenant.setPhoneNo(administrationForm.getPhoneNo());
			tenant.setPrimaryContact(administrationForm.getPhoneNo());
			tenant.setTenantName(administrationForm.getTenantName());
			tenant.setTenantId(tenantId);
			tenantService.createTenant(tenant);
			resetAdministrationForm(administrationForm);
			modelAndView.addObject("successMessage", "Tenant '"+tenantId+"' successfully created !!!");
		}
		modelAndView.addObject("form", administrationForm);
		log.debug("Existing..........");
		return modelAndView;
	}
	
	
	private void resetAdministrationForm(AdministrationForm administrationForm) {
		administrationForm.setAddress(null);
		administrationForm.setEmailAddress(null);
		administrationForm.setPhoneNo(null);
		administrationForm.setPrimaryContact(null);
		administrationForm.setTenantName(null);
		
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tenantName", "","Tenant Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primaryContact", "", "Primary Contact cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNo", "", "Phone Number cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "", "Email Address cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "Address cannot be blank");
	}

	/**
	 * @param profileService the profileService to set
	 */
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	/**
	 * @param tenantService the tenantService to set
	 */
	public void setTenantService(TenantService tenantService) {
		this.tenantService = tenantService;
	}
	
	
}
