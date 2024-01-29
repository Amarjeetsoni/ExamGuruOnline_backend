package com.ExamGuruOnline.serviceInterface;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.entity.User;

@Component
public interface LoginSignupServiceInterface {

	public User validateAndLogin(String userName, String password);
	public boolean validateProvidedEmail(String mailId);
	public boolean registerANewOrganization(String organizationName);
	public boolean validateProvidedDetailsOnSignupPage(User userDetails);
	public boolean signUp(User user);
}
