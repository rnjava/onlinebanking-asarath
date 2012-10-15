package com.openbank.onlinebanking.doa.impl;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.openbank.onlinebanking.doa.LoginDAO;
import com.openbank.onlinebanking.dto.User;

public class LoginDAOImpl implements LoginDAO {

	
	private MongoTemplate mongoTemplate;
	private Query query = null;
	
	@Override
	public User getUserByUserId(String userId) {
		User user = null;
		query = new Query(Criteria.where("_id").is(userId)
				.and("tenantId").is("123"));
        user = mongoTemplate.findOne(query, User.class, "users");
		return user;
	}

	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	
	
}
