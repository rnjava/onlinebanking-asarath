package com.openbank.onlinebanking.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.blo.TenantService;
import com.openbank.onlinebanking.dto.Profile;
import com.openbank.onlinebanking.dto.Tenant;
import com.openbank.onlinebanking.form.admin.AdministrationForm;
import com.openbank.onlinebanking.util.GuidUtil;
import com.openbank.onlinebanking.util.PropertyLoader;

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

	@RequestMapping(value="/addnewtenantsubmit",  headers = "content-type=multipart/form-data", method=RequestMethod.POST) 
	public ModelAndView createNewTenant(@ModelAttribute("form") AdministrationForm administrationForm, BindingResult result) {

		log.debug("Entering.....");
		ModelAndView modelAndView = new ModelAndView("adminloginsuccess");
		MultipartFile multipartFile = administrationForm.getFile();
		validate(administrationForm, result);
		validateMultiPart(multipartFile, result);
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
			File file = null;
			try {
				log.debug("Uploaded file : {} ", multipartFile.getOriginalFilename());
				String fileName = tenantId+".gif";
				String tomcatFolder = PropertyLoader.tomcatFolder;
				String projectFolder = PropertyLoader.projectFolder;
				
				log.debug("Tomcat path {}{}", tomcatFolder, fileName);
				file = new File(tomcatFolder+fileName);
				FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
			    
				log.debug("Project path {}{}", projectFolder, fileName);
				file = new File(projectFolder+fileName);
				FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
			} catch (Exception e) {
				log.debug("Error uploading file" + e);
			}
			
			Profile profile = profileService.getProfileById(administrationForm.getStaffProfileId(), tenantId);
			if(profile != null) {
				administrationForm.setStaffProfileId(profile.getProfileId());
				administrationForm.setStaffFirstName(profile.getFirstName());
				administrationForm.setStaffLastName(profile.getLastName());
			}

			modelAndView.addObject("successMessage", "Tenant '"+tenantId+"' successfully created !!!");
		}
		modelAndView.addObject("form", administrationForm);
		log.debug("Existing..........");
		return modelAndView;
	}
	
	
	private void validateMultiPart(MultipartFile multipartFile, BindingResult result) {
		if(multipartFile != null) {
			log.debug("File size {}", multipartFile.getSize());
			if(multipartFile.getSize() > 512000) {
				result.addError(new ObjectError("multipartFile", "File size cannot be greater than 500KB"));
			}
			
			if(!multipartFile.getOriginalFilename().endsWith("gif")) {
				result.addError(new ObjectError("multipartFile", "Wrong file type. Only gif is allowed"));
			}
			
		} else {
			result.addError(new ObjectError("multipartFile", "Please upload a tenant logo"));
		}
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
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "file", "", "Please upload tenant's logo");
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


//	/**
//	 * @param tomcatFolder the tomcatFolder to set
//	 */
//	public void setTomcatFolder(String tomcatFolder) {
//		this.tomcatFolder = tomcatFolder;
//	}
//
//
//	/**
//	 * @param projectFolder the projectFolder to set
//	 */
//	public void setProjectFolder(String projectFolder) {
//		this.projectFolder = projectFolder;
//	}
//
//
//	/**
//	 * @return the queueCapacity
//	 */
//	public String getQueueCapacity() {
//		return queueCapacity;
//	}
//
//
//	/**
//	 * @param queueCapacity the queueCapacity to set
//	 */
//	public void setQueueCapacity(String queueCapacity) {
//		System.out.println("***********queueCapacity" +queueCapacity);
//		this.queueCapacity = queueCapacity;
//	}
//	
	
}
