package com.ExamGuruOnline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrganizationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orgId;
	private String orgName;
	
	public OrganizationDetails() {
		super();
	}

	public OrganizationDetails(Long orgId, String orgName) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
	}

	public OrganizationDetails(String orgName) {
		super();
		this.orgName = orgName;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "OrganizationDetails [orgId=" + orgId + ", orgName=" + orgName + "]";
	}
	
	
	
}
