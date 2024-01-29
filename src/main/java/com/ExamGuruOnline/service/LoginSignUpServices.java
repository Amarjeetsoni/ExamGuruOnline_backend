package com.ExamGuruOnline.service;

import org.springframework.stereotype.Service;

import com.ExamGuruOnline.entity.User;
import com.ExamGuruOnline.serviceInterface.LoginSignupServiceInterface;

@Service
public class LoginSignUpServices implements LoginSignupServiceInterface{

	@Override
	public User validateAndLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateProvidedEmail(String mailId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerANewOrganization(String organizationName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateProvidedDetailsOnSignupPage(User userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signUp(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
