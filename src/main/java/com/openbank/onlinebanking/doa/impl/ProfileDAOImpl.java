package com.openbank.onlinebanking.doa.impl;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.openbank.onlinebanking.doa.ProfileDAO;
import com.openbank.onlinebanking.dto.Profile;

public class ProfileDAOImpl implements ProfileDAO {

	private MongoTemplate mongoTemplate;
	private Query query = null;
	
	@Override
	public Profile getProfileById(String profileId, String tenantId) {
		Profile profile = null;
		query = new Query(Criteria.where("_id").is(profileId)
				.and("tenantId").is(tenantId));
		profile = mongoTemplate.findOne(query, Profile.class, "profile");

		return profile;
		
	}
	
	

	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}	
}
