package com.openbank.onlinebanking.doa.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.openbank.onlinebanking.doa.BaseDAO;
import com.openbank.onlinebanking.doa.LoginDAO;
import com.openbank.onlinebanking.dto.User;

public class LoginDAOImpl extends BaseDAO implements LoginDAO {

	private Query query = null;
	
	@Override
	public User getUserByUserId(String userId, String tenantId) {
		User user = null;
		query = new Query(Criteria.where("_id").is(userId)
				.and("tenantId").is(tenantId));
        user = mongoTemplate.findOne(query, User.class, "users");
		return user;
	}

}
