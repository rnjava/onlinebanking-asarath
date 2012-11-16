package com.openbank.onlinebanking.doa.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.openbank.onlinebanking.doa.BaseDAO;
import com.openbank.onlinebanking.doa.TenantDAO;
import com.openbank.onlinebanking.dto.Tenant;

public class TenantDOAImpl  extends BaseDAO  implements TenantDAO {
	
	
	private static Logger log = LoggerFactory.getLogger(TenantDOAImpl.class);
	
	private Query query = null;

	public void createTenant(Tenant tenant) {
		mongoTemplate.save(tenant, TENANT_COLLECTION_NAME);
	}

	public List<Tenant> findTenant(String tenantName, String tenantId) {
		
		if(tenantId != null && !tenantId.trim().isEmpty()) {
			query = new Query(Criteria.where("tenantId").is(tenantId));
		} else {
			query = new Query(Criteria.where("tenantName").regex("/*"+tenantName+"*/"));
		}
		log.debug("Query : " + query);
		List<Tenant> tenantList = mongoTemplate.find(query, Tenant.class, TENANT_COLLECTION_NAME);
		return tenantList;
	}

	public List<Tenant> findAllTenant() {
		return mongoTemplate.findAll(Tenant.class, TENANT_COLLECTION_NAME);
	}

}
