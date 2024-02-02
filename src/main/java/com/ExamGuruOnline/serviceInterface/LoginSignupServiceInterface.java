package com.ExamGuruOnline.serviceInterface;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.customeException.NoUserFound;
import com.ExamGuruOnline.customeException.UserAlreadyPresentException;
import com.ExamGuruOnline.entity.User;

@Component
public interface LoginSignupServiceInterface {

	public User validateAndLogin(String userName, String password) throws NoUserFound;
	public boolean validateProvidedEmail(String mailId) throws UserAlreadyPresentException;
	public boolean registerANewOrganization(String organizationName) throws Exception;
	public boolean validateProvidedDetailsOnSignupPage(User userDetails) throws UserAlreadyPresentException;
	public boolean signUp(User user) throws UserAlreadyPresentException;
}
