package com.openbank.onlinebanking.blo.impl;

import java.util.List;

import com.openbank.onlinebanking.blo.TenantService;
import com.openbank.onlinebanking.doa.TenantDAO;
import com.openbank.onlinebanking.dto.Tenant;

public class TenantServiceImpl implements TenantService {

	private TenantDAO tenantDAO;
	
	public void createTenant(Tenant tenant) {
		tenantDAO.createTenant(tenant);
	}

	public List<Tenant> findTenant(String tenantName, String tenantId) {
		return tenantDAO.findTenant(tenantName, tenantId);
	}

	/**
	 * @param tenantDAO the tenantDAO to set
	 */
	public void setTenantDAO(TenantDAO tenantDAO) {
		this.tenantDAO = tenantDAO;
	}

	public List<Tenant> findAllTenant() {
		return tenantDAO.findAllTenant();	
	}

	
}
