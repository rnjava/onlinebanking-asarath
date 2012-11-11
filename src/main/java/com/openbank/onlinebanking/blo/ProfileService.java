package com.openbank.onlinebanking.blo;

import com.openbank.onlinebanking.dto.Profile;

public interface ProfileService {

	Profile getProfileById(String profileId, String tenantId);
	String saveProfile(Profile profile);
	boolean deleteProfile(String profileId, String tenantId);

}
