package com.openbank.onlinebanking.doa.impl;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.openbank.onlinebanking.doa.BaseDAO;
import com.openbank.onlinebanking.doa.LoginDAO;
import com.openbank.onlinebanking.dto.User;

public class LoginDAOImpl extends BaseDAO implements LoginDAO {

	private Query query = null;
	
	private static Logger log = LoggerFactory.getLogger(LoginDAOImpl.class);
	
	
	
	public User getUserByUserId(String userId, String tenantId) {
		log.debug("entering.......");
		User user = null;
		query = new Query(Criteria.where("userId").is(userId)
				.and("tenantId").is(tenantId));
		log.debug("Query : " + query);
        user = mongoTemplate.findOne(query, User.class, USERS_COLLECTION_NAME);
        //log.debug("User : " + user.toString());
		return user;
	}
	
	public void saveUser(User user) {
		log.debug("entering.......");
		mongoTemplate.save(user, USERS_COLLECTION_NAME);
	}
	
	public void deleteUser(String userId, String tenantId) {
		log.debug("entering.......");
		
		query = new Query(Criteria.where("userId").is(userId)
				.and("tenantId").is(tenantId));
		log.debug("Query : " + query);
		
		mongoTemplate.remove(query, USERS_COLLECTION_NAME);
	}

	public User getUserByProfileId(String tenantId, String profileId) {
		log.debug("entering.......");
		User user = null;
		query = new Query(Criteria.where("profileId").is(profileId)
				.and("tenantId").is(tenantId));
		log.debug("Query : " + query);
        user = mongoTemplate.findOne(query, User.class, USERS_COLLECTION_NAME);
		return user;

	}

	public void updateUser(User user) {
		query = new Query(Criteria.where("_id").is(new ObjectId(user.getId())));
		log.debug("Query : " + query);
		mongoTemplate.updateFirst(query, new Update().set("password", user.getPassword()), USERS_COLLECTION_NAME);
	}

}
