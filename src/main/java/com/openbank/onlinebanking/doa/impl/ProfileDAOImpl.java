package com.openbank.onlinebanking.doa.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.openbank.onlinebanking.doa.BaseDAO;
import com.openbank.onlinebanking.doa.ProfileDAO;
import com.openbank.onlinebanking.dto.Profile;

public class ProfileDAOImpl extends BaseDAO implements ProfileDAO {

	private static final String PROFILE_COLLECTION_NAME = "profile";
	
	private Query query = null;
	private static Logger log = LoggerFactory.getLogger(ProfileDAOImpl.class);
	
	public Profile getProfileById(String profileId, String tenantId) {
		Profile profile = null;
		query = new Query(Criteria.where("profileId").is(profileId)
				.and("tenantId").is(tenantId));
		log.debug("Query : "+ query);
		profile = mongoTemplate.findOne(query, Profile.class, PROFILE_COLLECTION_NAME);
		//log.debug("Profile : " + profile.toString());
		return profile;
	}
	
	public void saveProfile(Profile profile	) {
		log.debug("Entering.......");
		mongoTemplate.save(profile, PROFILE_COLLECTION_NAME);
	}
	
	public void deleteProfile(String profileId, String tenantId) {
		query = new Query(Criteria.where("profileId").is(profileId)
				.and("tenantId").is(tenantId));
		log.debug("Query : "+ query);
		mongoTemplate.remove(query, PROFILE_COLLECTION_NAME);
	}
	
}
