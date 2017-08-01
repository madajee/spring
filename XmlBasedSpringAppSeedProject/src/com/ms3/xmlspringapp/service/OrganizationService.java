package com.ms3.xmlspringapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms3.xmlspringapp.dao.OrganizationDao;
import com.ms3.xmlspringapp.domain.Organization;


@Service
public class OrganizationService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(OrganizationService.class);
	
	@Autowired
	private OrganizationDao organizationDao;
	
	public List<Organization> getOrgList() {
		List<Organization> orgList = organizationDao.getAllOrganizations();
		LOGGER.info("In OrganizationService Class");
		return orgList;
	}
}