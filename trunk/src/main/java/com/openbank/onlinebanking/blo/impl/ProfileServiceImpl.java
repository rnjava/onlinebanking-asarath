package com.openbank.onlinebanking.blo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.doa.ProfileDAO;
import com.openbank.onlinebanking.dto.Profile;
import com.openbank.onlinebanking.util.GuidUtil;

public class ProfileServiceImpl implements ProfileService {
	
	private ProfileDAO profileDAO;
	
	private static Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);
	
	public Profile getProfileById(String profileId, String  tenantId) {
		return profileDAO.getProfileById(profileId, tenantId);
	}
	
	public String saveProfile(Profile profile) {
		log.debug("Entering.......");
		String profileId = GuidUtil.generateGuid();
		log.debug("profileId :{} for {} ", new Object[]{profileId, profile.toString()}); 
		profile.setProfileId(profileId);
		profileDAO.saveProfile(profile);
		return profileId;
	}
	
	public boolean deleteProfile(String profileId, String tenantId) {
		log.debug("Entering.......");
		boolean ret = false;
		profileDAO.deleteProfile(profileId, tenantId);
		ret = true;
		return ret;
	}

	/**
	 * @param profileDAO the profileDAO to set
	 */
	public void setProfileDAO(ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}

	
}
