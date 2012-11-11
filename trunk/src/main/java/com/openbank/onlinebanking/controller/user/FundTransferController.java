package com.openbank.onlinebanking.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openbank.onlinebanking.blo.FundTransferService;
import com.openbank.onlinebanking.dto.FundRecipient;
import com.openbank.onlinebanking.form.TransferForm;

@Controller
//@RequestMapping("/user")
public class FundTransferController {
	
	private FundTransferService fundTransferService;
	
	@RequestMapping(value="/maketransfer", method=RequestMethod.GET)
	public ModelAndView makeTransfer(@RequestParam(value = "profileid") String profileId, 
			@RequestParam (value = "tenantid") String tenantId) {

		TransferForm form = new TransferForm();
		form.setTenantId(tenantId);
		form.setProfileId(profileId);
		ModelAndView modelAndView = new ModelAndView("maketransfer");
		modelAndView.addObject("form", form);
		return modelAndView;
	}

	@RequestMapping(value="/addrecipient", method=RequestMethod.GET)
	public ModelAndView addRecipient(@RequestParam(value = "profileid") String profileId, 
			@RequestParam (value = "tenantid") String tenantId) {
				
		TransferForm form = new TransferForm();
		form.setTenantId(tenantId);
		form.setProfileId(profileId);
		ModelAndView modelAndView = new ModelAndView("addrecipient");
		modelAndView.addObject("form", form);
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addNewRecipient", method=RequestMethod.POST)
	public ModelAndView addNewRecipient(TransferForm form) {

		FundRecipient fundRecipient = new FundRecipient();
		fundRecipient.setLastName(form.getLastName());
		fundRecipient.setNickName(form.getNickName());
		fundRecipient.setProfileId(form.getProfileId());
		fundRecipient.setRecipientAccountNo(form.getRecipientAccountNo());
		fundRecipient.setTenantId(form.getTenantId());
		
		fundTransferService.createFundRecipient(fundRecipient);
		
		ModelAndView modelAndView = new ModelAndView("addrecipient");
		modelAndView.addObject("form", form);
		return modelAndView;
	}

	/**
	 * @param fundTransferService the fundTransferService to set
	 */
	public void setFundTransferService(FundTransferService fundTransferService) {
		this.fundTransferService = fundTransferService;
	}
	
	

}
