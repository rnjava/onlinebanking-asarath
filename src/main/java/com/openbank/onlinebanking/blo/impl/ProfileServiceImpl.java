package com.openbank.onlinebanking.blo.impl;

import com.openbank.onlinebanking.blo.ProfileService;
import com.openbank.onlinebanking.doa.ProfileDAO;
import com.openbank.onlinebanking.dto.Profile;

public class ProfileServiceImpl implements ProfileService {
	
	private ProfileDAO profileDAO;
	
	@Override
	public Profile getProfileById(String profileId, String  tenantId) {
		return profileDAO.getProfileById(profileId, tenantId);
	}

	/**
	 * @param profileDAO the profileDAO to set
	 */
	public void setProfileDAO(ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}

	
}
