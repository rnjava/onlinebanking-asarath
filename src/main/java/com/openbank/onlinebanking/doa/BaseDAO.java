package com.openbank.onlinebanking.doa;

import org.springframework.data.mongodb.core.MongoTemplate;

public class BaseDAO {

	protected MongoTemplate mongoTemplate;
	
	protected static final String USERS_COLLECTION_NAME = "users";
	

	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
