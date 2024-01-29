package com.ExamGuruOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ExamGuruOnline.customeException.NoOrganizationRegistered;
import com.ExamGuruOnline.serviceInterface.OrganizationDetailsServiceInterface;

@RestController
@RequestMapping(value = "org")
@CrossOrigin("*")
public class OrganizationController {

	@Autowired
	private OrganizationDetailsServiceInterface orgInterface;
	
	@PostMapping("/addOrg")
	public ResponseEntity<Object> addNewOrganization(@RequestBody String organization){
			try {
				orgInterface.addOrganizationDetails(organization.toUpperCase());
				return new ResponseEntity<Object>("Organization: " + organization + " Added Successfully!!", HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
			}
	}
	
	@PutMapping("/updateOrg")
	public ResponseEntity<Object> updateOrganizationName(@RequestParam Long id, @RequestParam String org){
		try {
			orgInterface.updateOrganizationDetail(id, org.toUpperCase());
			return new ResponseEntity<Object>("Organization Name: " + org + " updated Successfully!!", HttpStatus.OK);
		}catch(NoOrganizationRegistered ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteOrg")
	public ResponseEntity<Object> deleteOrganizationById(@RequestParam Long id){
		try {
			orgInterface.deleteOrganizationDetails(id);
			return new ResponseEntity<Object>("Organization Id: " + id + " Removed!!", HttpStatus.OK);
		}catch (NoOrganizationRegistered e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getOrg")
	public ResponseEntity<Object> getOrganizationById(@RequestParam Long id){
		try {
			return new ResponseEntity<Object>(orgInterface.getOrganizationDetail(id), HttpStatus.OK);
		}catch (NoOrganizationRegistered e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllOrg")
	public ResponseEntity<Object> getAllOrganization(){
		try {
			return new ResponseEntity<Object>(orgInterface.getAllOrganizationDetails(), HttpStatus.OK);
		}catch (NoOrganizationRegistered e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/deleteAllOrg")
	public ResponseEntity<Object> deleteAllOrganization(){
		try {
			return new ResponseEntity<Object>(orgInterface.deleteAllOrganizationDetails(), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
