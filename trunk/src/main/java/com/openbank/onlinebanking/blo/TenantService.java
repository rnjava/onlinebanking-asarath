package com.openbank.onlinebanking.blo;

import java.util.List;

import com.openbank.onlinebanking.dto.Tenant;

public interface TenantService {

	public void createTenant(Tenant tenant);
	public List<Tenant> findTenant(String tenantName, String tenantId);
	public List<Tenant> findAllTenant();
}
