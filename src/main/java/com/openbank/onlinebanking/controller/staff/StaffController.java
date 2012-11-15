package com.openbank.onlinebanking.controller.staff;

import java.util.Date;
import java.util.LinkedHashMap;
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

import com.openbank.onlinebanking.blo.AccountService;
import com.openbank.onlinebanking.blo.LoginService;
import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.dto.Account;
import com.openbank.onlinebanking.dto.Profile;
import com.openbank.onlinebanking.dto.Role;
import com.openbank.onlinebanking.dto.User;
import com.openbank.onlinebanking.form.staff.CreateAccountForm;
import com.openbank.onlinebanking.util.AppUtil;

import static com.openbank.onlinebanking.util.ApplicationConstants.CUSTOMER_ROLE;
import static com.openbank.onlinebanking.util.ApplicationConstants.DATE_FORMAT;

@Controller
public class StaffController {
	
	private ProfileService profileService;
	private AccountService accountService;
	private LoginService loginService;
	
	private static Logger log = LoggerFactory.getLogger(StaffController.class);

	@RequestMapping(value="/staffcreateaccount",  method=RequestMethod.GET)
	public ModelAndView createAccountFormLoad(@RequestParam(value = "tenantid") String tenantId, @RequestParam(value = "profileid") String profileId ) {

		log.debug("Entering....");
		CreateAccountForm createAccountForm = new CreateAccountForm();
		createAccountForm.setTenantId(tenantId);
		createAccountForm.setStaffProfileId(profileId);
		ModelAndView modelAndView = new ModelAndView("staffcreateaccount");
		modelAndView.addObject("accountTypeList", loadAccountTypeMap());
		
		modelAndView.addObject("form", createAccountForm);
		log.debug("Existing..........");
		return modelAndView;
	}

	@RequestMapping(value="/staffcreateaccount",  method=RequestMethod.POST)
	public ModelAndView createAccountFormSubmit(@ModelAttribute("form") CreateAccountForm createAccountForm, BindingResult result) {

		log.debug("Entering - CreateAccountForm : {}", createAccountForm.toString());
		ModelAndView modelAndView = new ModelAndView("staffcreateaccount");
		boolean isSuccess = true;
		validate(createAccountForm, result);
		if(createAccountForm.getPhoneNo()!= null) {
			if(!AppUtil.isAValidDDMMYYYYDate(createAccountForm.getDateOfBirth())) {
				log.error("Invalid date format " + createAccountForm.getDateOfBirth()); 
				isSuccess = false;
				result.addError(new ObjectError("dateOfBirth", "Invalid dateOfBirth. Please use the format " + DATE_FORMAT ));
			}
		}
		if(isSuccess && !result.hasErrors()) {
			
			String tenantId = createAccountForm.getTenantId();
			Profile staffProfile = profileService.getProfileById(createAccountForm.getStaffProfileId(), tenantId);
			if(staffProfile != null) {
				createAccountForm.setStaffFirstName(staffProfile.getFirstName());
				createAccountForm.setStaffLastName(staffProfile.getLastName());
			}
			
			
			//Create Profile
			String profileId = profileService.saveProfile(createProfile(createAccountForm));
			String accountNo = null;
			try {
				//Create Use Account
				loginService.CreateUser(createUser(createAccountForm, profileId));

			} catch (Exception e) {
				log.error("Error Creating User {} ", e);
				isSuccess = false;
				profileService.deleteProfile(profileId, tenantId);
				
			}
			
			try {
				//Create Account
				accountNo = accountService.saveAccount(createAccount(createAccountForm, profileId));
				log.debug("Account No. " + accountNo);
			} catch (Exception e) {
				log.error("Error Creating Account {} ", e);
				isSuccess = false;
				loginService.deleteUser(createAccountForm.getUserName(), tenantId);
				profileService.deleteProfile(profileId, tenantId);
				
			}
			if(isSuccess) {
				modelAndView.addObject("successMessage", "Account '"+accountNo+"' successfully created !!!");
				resetForm(createAccountForm);
			} else {
				result.addError(new ObjectError("account", "Error Opening new account"));
			}

		}
		modelAndView.addObject("form", createAccountForm);
		modelAndView.addObject("accountTypeList", loadAccountTypeMap());
		log.debug("Existing..........");
		return modelAndView;
	}
	
	private void resetForm(CreateAccountForm createAccountForm) {
		createAccountForm.setAccountType(null);
		createAccountForm.setFirstName(null);
		createAccountForm.setLastName(null);
		createAccountForm.setDateOfBirth(null);
		createAccountForm.setBranchCode(null);
		createAccountForm.setSex(null);
		createAccountForm.setUserName(null);
		createAccountForm.setAddress(null);
		createAccountForm.setPhoneNo(null);
		createAccountForm.setEmailAddress(null);
	}
	
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountType", "","Account Type cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "", "First Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "", "Last Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "", "Sex cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "", "Date of Birth cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "", "User Name cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "Address cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "", "Email Address cannot be blank");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNo", "", "Phone cannot be blank");
	    
	}
	
	
	private Map<String,String> loadAccountTypeMap() {
		Map<String,String> modeMap = new LinkedHashMap<String,String>();
			modeMap.put("Savings", "Savings");
			modeMap.put("Current", "Current");
		return modeMap;
	}	

	private User createUser(CreateAccountForm createAccountForm, String profileId) {
		User user = new User();
		user.setUserId(createAccountForm.getUserName());
		user.setProfileId(profileId);
		user.setTenantId(createAccountForm.getTenantId());
		user.setCreatedBy(createAccountForm.getStaffFirstName() +" "+ createAccountForm.getStaffLastName());
		user.setCreatedDate(new Date());
		Role role = new Role();
		role.setPrimary(CUSTOMER_ROLE);
		user.setRole(role);
		return user;
	}
	
	private Profile createProfile(CreateAccountForm createAccountForm) {
		Profile profile = new Profile();
		profile.setFirstName(createAccountForm.getFirstName());
		profile.setLastName(createAccountForm.getLastName());
		profile.setDateOfBirth(AppUtil.getDateFromStr(createAccountForm.getDateOfBirth()));
		profile.setAddress(createAccountForm.getAddress());
		profile.setEmailAddress(createAccountForm.getEmailAddress());
		profile.setPhone(createAccountForm.getPhoneNo());
		profile.setTenantId(createAccountForm.getTenantId());
		profile.setSex(createAccountForm.getSex());
		profile.setCreatedBy(createAccountForm.getStaffFirstName() +" "+ createAccountForm.getStaffLastName());
		profile.setCreatedDate(new Date());
		return profile;
	}
	
	private Account createAccount(CreateAccountForm createAccountForm, String profileId) {
		Account account = new Account();
		account.setProfileId(profileId);
		account.setType(createAccountForm.getAccountType());
		account.setCreatedBy(createAccountForm.getStaffFirstName() +" "+ createAccountForm.getStaffLastName());
		account.setCreatedDate(new Date());
		account.setTenantId(createAccountForm.getTenantId());
		return account;
	}
	

	/**
	 * @param profileService the profileService to set
	 */
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	/**
	 * @param accountService the accountService to set
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	

}

