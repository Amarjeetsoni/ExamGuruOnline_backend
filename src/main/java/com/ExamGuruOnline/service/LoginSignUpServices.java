package com.ExamGuruOnline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamGuruOnline.customeException.NoUserFound;
import com.ExamGuruOnline.customeException.UserAlreadyPresentException;
import com.ExamGuruOnline.entity.User;
import com.ExamGuruOnline.serviceInterface.LoginSignupServiceInterface;
import com.ExamGuruOnline.serviceInterface.OrganizationDetailsServiceInterface;
import com.ExamGuruOnline.serviceInterface.UserServiceInterface;

@Service
public class LoginSignUpServices implements LoginSignupServiceInterface{

	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private OrganizationDetailsServiceInterface orgService;
	
	@Override
	public User validateAndLogin(String userName, String password) throws NoUserFound {
		try {
			User user = userService.getUserById(userName);
			if(user.getPassword().equals(password)) {
				user.setPassword("****");
				user.setSecurityAnswer("****");
				user.setOrganizationId(0L);
				return user;
			}else {
				throw new NoUserFound("Worng Password !!, Please Enter again or Try to Reset.");
			}
		} catch (NoUserFound e) {
			throw new NoUserFound("No User Found With Provided MailId, Please Validate and try Again !!");
		}
	}

	@Override
	public boolean validateProvidedEmail(String mailId) throws UserAlreadyPresentException {
		try {
			return userService.validateNewUser(mailId);
		} catch (UserAlreadyPresentException e) {
			throw e;
		}
	}

	@Override
	public boolean registerANewOrganization(String organizationName) throws Exception {
		try {
			return orgService.addOrganizationDetails(organizationName);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean validateProvidedDetailsOnSignupPage(User userDetails) throws UserAlreadyPresentException {
		try {
			return validateProvidedEmail(userDetails.getEmail());
		} catch (UserAlreadyPresentException e) {
			throw e;
		}
	}

	@Override
	public boolean signUp(User user) throws UserAlreadyPresentException {
		try {
			validateProvidedEmail(user.getEmail());
			return userService.addNewUser(user);
		} catch (UserAlreadyPresentException e) {
			throw e;
		}
	}

}
