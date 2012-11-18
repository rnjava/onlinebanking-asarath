package com.openbank.onlinebanking.controller;

import static com.openbank.onlinebanking.util.ApplicationConstants.DATE_FORMAT;
import static com.openbank.onlinebanking.util.ApplicationConstants.STAFF_ADMIN_ROLE;
import static com.openbank.onlinebanking.util.ApplicationConstants.STAFF_ROLE;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.blo.TenantService;
import com.openbank.onlinebanking.dto.Profile;
import com.openbank.onlinebanking.dto.Role;
import com.openbank.onlinebanking.dto.Tenant;
import com.openbank.onlinebanking.dto.User;
import com.openbank.onlinebanking.form.UserForm;
import com.openbank.onlinebanking.util.AppUtil;

@Controller
public class UserManagementConroller {

	private ProfileService profileService;
	private LoginService loginService;
	private TenantService tenantService;
	
	private static Logger log = LoggerFactory.getLogger(UserManagementConroller.class);
	
	@RequestMapping(value="/createuser",  method=RequestMethod.GET)
	public ModelAndView createAccount(@RequestParam(value = "tenantid") String tenantId, @RequestParam(value = "profileid") String staffProfileId ) {

		log.debug("Entering....");
		UserForm userForm = new UserForm();
		userForm.setTenantId(tenantId);
		userForm.setStaffProfileId(staffProfileId);
		ModelAndView modelAndView = new ModelAndView("adminusercreation");
		modelAndView.addObject("roleType", loadRoleMap());
		modelAndView.addObject("tenantList", loadTenantMap());
		modelAndView.addObject("form", userForm);
		log.debug("Existing..........");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/createusersubmit",  method=RequestMethod.POST)
	public ModelAndView createUserSubmit(@ModelAttribute("form") UserForm userForm, BindingResult result) {

		log.debug("Entering....");
		ModelAndView modelAndView = new ModelAndView("adminusercreation");
		
		boolean isSuccess = true;
		validate(userForm, result);
		if(userForm.getDateOfBirth()!= null) {
			if(!AppUtil.isAValidDDMMYYYYDate(userForm.getDateOfBirth())) {
				log.error("Invalid date format " + userForm.getDateOfBirth()); 
				isSuccess = false;
				result.addError(new ObjectError("dateOfBirth", "Invalid dateOfBirth. Please use the format " + DATE_FORMAT ));
			}
		}
		if(isSuccess && !result.hasErrors()) {
			
			String tenantId = userForm.getTenantId();
			Profile staffProfile = profileService.getProfileById(userForm.getStaffProfileId(), tenantId);
			if(staffProfile != null) {
				userForm.setStaffFirstName(staffProfile.getFirstName());
				userForm.setStaffLastName(staffProfile.getLastName());
			}
			
			
			//Create Profile
			String profileId = profileService.saveProfile(createProfile(userForm));
			try {
				//Create Use Account
				loginService.CreateUser(createUser(userForm, profileId));

			} catch (Exception e) {
				log.error("Error Creating User {} ", e);
				isSuccess = false;
				profileService.deleteProfile(profileId, tenantId);
				
			}
			
		if(isSuccess) {
				modelAndView.addObject("successMessage", "User '"+ userForm.getUserName() +"' successfully created !!!");
				resetForm(userForm);
			} else {
				result.addError(new ObjectError("userAccount", "Error creating new user"));
			}

		}		
		modelAndView.addObject("roleType", loadRoleMap());
		modelAndView.addObject("tenantList", loadTenantMap());
		modelAndView.addObject("form", userForm);
		log.debug("Existing..........");
		return modelAndView;
	}
	
	
	private Map<String,String> loadRoleMap() {
		Map<String,String> modeMap = new LinkedHashMap<String,String>();
			modeMap.put(STAFF_ROLE, "Staff");
			modeMap.put(STAFF_ADMIN_ROLE, "Admin");
		return modeMap;
	}	
	
	private Map<String,String> loadTenantMap() {
		Map<String,String> modeMap = new LinkedHashMap<String,String>();
		List<Tenant> list = tenantService.findAllTenant();
		if(list != null) {
			for(Tenant t : list) {
				modeMap.put(t.getTenantId(), t.getTenantName());
			}
		}
		return modeMap;
	}	

	
	private void resetForm(UserForm form) {
		form.setRole(null);
		form.setFirstName(null);
		form.setLastName(null);
		form.setDateOfBirth(null);
		form.setUserTenandId(null);
		form.setSex(null);
		form.setUserName(null);
		form.setAddress(null);
		form.setPhoneNo(null);
		form.setEmailAddress(null);
	}
	
	private User createUser(UserForm form, String profileId) {
		User user = new User();
		user.setUserId(form.getUserName());
		user.setProfileId(profileId);
		user.setTenantId(form.getUserTenandId());
		user.setCreatedBy(form.getStaffFirstName() +" "+ form.getStaffLastName());
		user.setCreatedDate(new Date());
		Role role = new Role();
		role.setPrimary(STAFF_ROLE);
		role.setSecondary(form.getRole());
		user.setRole(role);
		return user;
	}	
	private Profile createProfile(UserForm form) {
		Profile profile = new Profile();
		profile.setFirstName(form.getFirstName());
		profile.setLastName(form.getLastName());
		profile.setDateOfBirth(AppUtil.getDateFromStr(form.getDateOfBirth()));
		profile.setAddress(form.getAddress());
		profile.setEmailAddress(form.getEmailAddress());
		profile.setPhone(form.getPhoneNo());
		profile.setTenantId(form.getUserTenandId());
		profile.setSex(form.getSex());
		profile.setCreatedBy(form.getStaffFirstName() +" "+ form.getStaffLastName());
		profile.setCreatedDate(new Date());
		return profile;
	}
	
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userTenandId", "","Tenant Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "", "First Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "", "Last Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "", "Sex cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "", "Date of Birth cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "", "User Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "Address cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "", "Email Address cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNo", "", "Phone cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "", "Role cannot be blank");

	    
	}


	/**
	 * @param profileService the profileService to set
	 */
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}


	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	/**
	 * @param tenantService the tenantService to set
	 */
	public void setTenantService(TenantService tenantService) {
		this.tenantService = tenantService;
	}
	
	
}
