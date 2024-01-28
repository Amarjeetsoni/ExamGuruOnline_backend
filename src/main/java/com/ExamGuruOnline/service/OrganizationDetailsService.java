package com.ExamGuruOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ExamGuruOnline.customeException.NoOrganizationRegistered;
import com.ExamGuruOnline.entity.OrganizationDetails;
import com.ExamGuruOnline.repository.OrganizationDetailsRepo;
import com.ExamGuruOnline.serviceInterface.OrganizationDetailsServiceInterface;

public class OrganizationDetailsService implements OrganizationDetailsServiceInterface{

	@Autowired
	private OrganizationDetailsRepo orgRepo;
	
	@Override
	public boolean addOrganizationDetails(String name) throws Exception {
		if(checkIfOrganizationAlreadyPresent(name)) {
			throw new Exception("Organization with Name: " + name + " Already Registered");
		}
		OrganizationDetails od = new OrganizationDetails(name);
		orgRepo.save(od);
		return true;
	}
	
	private boolean checkIfOrganizationAlreadyPresent(String check) {
		List<OrganizationDetails> allOrg = orgRepo.findAll();
		if(allOrg != null && allOrg.size() > 0) {
			if(allOrg.stream().filter(name -> name.getOrgName().equals(check)).count() > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteOrganizationDetails(Long Id) throws NoOrganizationRegistered {
		Optional<OrganizationDetails> org = orgRepo.findById(Id);
		if(org.isPresent()) {
			orgRepo.deleteById(Id);
			return true;
		}else {
			throw new NoOrganizationRegistered("No Organization found with Id :  " + Id);
		}
	}

	@Override
	public OrganizationDetails updateOrganizationDetail(Long id, String name) throws NoOrganizationRegistered {
		Optional<OrganizationDetails> org = orgRepo.findById(id);
		if(org.isPresent()) {
			org.get().setOrgName(name);
			orgRepo.save(org.get());
			return org.get();
		}else {
			throw new NoOrganizationRegistered("No Organization found with Id :  " + id);
		}
	}

	@Override
	public OrganizationDetails getOrganizationDetail(Long Id) throws NoOrganizationRegistered {
		Optional<OrganizationDetails> org = orgRepo.findById(Id);
		if(org.isPresent()) {
			return org.get();
		}else {
			throw new NoOrganizationRegistered("No Organization found with Id :  " + Id);
		}
	}

	@Override
	public List<OrganizationDetails> getAllOrganizationDetails() throws NoOrganizationRegistered {
		List<OrganizationDetails> allOrg = orgRepo.findAll();
		if(allOrg != null && allOrg.size() > 0) {
			return allOrg;
		}
		throw new NoOrganizationRegistered("No Organization Registered Yet!!");
	}

	@Override
	public boolean deleteAllOrganizationDetails() {
		orgRepo.deleteAll();
		return true;
	}

}
