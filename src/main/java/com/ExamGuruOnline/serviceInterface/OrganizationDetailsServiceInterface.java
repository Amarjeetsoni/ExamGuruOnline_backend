package com.ExamGuruOnline.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.customeException.NoOrganizationRegistered;
import com.ExamGuruOnline.entity.OrganizationDetails;

@Component
public interface OrganizationDetailsServiceInterface {
	public boolean addOrganizationDetails(String od) throws Exception;
	public boolean deleteOrganizationDetails(Long Id) throws NoOrganizationRegistered;
	public OrganizationDetails updateOrganizationDetail(Long id, String name) throws NoOrganizationRegistered;
	public OrganizationDetails getOrganizationDetail(Long Id) throws NoOrganizationRegistered;
	public List<OrganizationDetails> getAllOrganizationDetails() throws NoOrganizationRegistered;
	public boolean deleteAllOrganizationDetails();
}
