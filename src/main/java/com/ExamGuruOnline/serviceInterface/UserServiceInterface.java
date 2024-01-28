package com.ExamGuruOnline.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ExamGuruOnline.customeException.NoUserFound;
import com.ExamGuruOnline.customeException.UserAlreadyPresentException;
import com.ExamGuruOnline.entity.User;

@Component
public interface UserServiceInterface {
	public boolean addNewUser(User user);
	public boolean validateNewUser(String emailId) throws UserAlreadyPresentException;
	public boolean deleteUser(String mailId) throws NoUserFound;
	public User updateUserDetails(User user) throws NoUserFound;
	public User getUserById(String mailId) throws NoUserFound;
	public boolean validateUserForChangePassword(String mailId, Long securityQuestion, String securityAnswer) throws NoUserFound;
	public boolean changePassword(String mailId, String password) throws NoUserFound;
	public List<User> getAllUsers() throws NoUserFound;
}
