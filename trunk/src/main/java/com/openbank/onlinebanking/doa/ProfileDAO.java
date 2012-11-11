package com.openbank.onlinebanking.doa;

import com.openbank.onlinebanking.dto.Profile;

public interface ProfileDAO {

	Profile getProfileById(String profileId, String tenantId);
	void saveProfile(Profile profile);
	void deleteProfile(String profileId, String tenantId);

}
