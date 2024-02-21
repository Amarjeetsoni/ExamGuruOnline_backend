package com.ExamGuruOnline.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamGuruOnline.customeException.NoUserFound;
import com.ExamGuruOnline.customeException.UserAlreadyPresentException;
import com.ExamGuruOnline.entity.User;
import com.ExamGuruOnline.repository.UserRepo;
import com.ExamGuruOnline.serviceInterface.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean addNewUser(User user) {
		userRepo.save(user);
		return true;
	}

	@Override
	public boolean validateNewUser(String emailId) throws UserAlreadyPresentException {
		Optional<User> user = userRepo.findById(emailId);
		if(user.isPresent()) {
			throw new UserAlreadyPresentException("User Already Present with Id: " + emailId);
		}else {
			return true;
		}
	}

	@Override
	public boolean deleteUser(String mailId) throws NoUserFound {
		try {
			getUserById(mailId);
		}catch(NoUserFound exception) {
			throw exception;
		}
		userRepo.deleteById(mailId);
		return true;
	}

	@Override
	public User updateUserDetails(User user) throws NoUserFound {
		Optional<User> currentUser = userRepo.findById(user.getEmail());
		if(currentUser.isPresent()) {
			if(user.getName() != null) {
				currentUser.get().setName(user.getName());
			}
			if(user.getOrganizationId() != null) {
				currentUser.get().setOrganizationId(user.getOrganizationId());
			}
			if(user.getSecurityAnswer() != null) {
				currentUser.get().setSecurityAnswer(user.getSecurityAnswer());
			}
			if(user.getSecurityQuestionId() != null) {
				currentUser.get().setSecurityQuestionId(user.getSecurityQuestionId());
			}
			if(user.getPassword() != null) {
				currentUser.get().setPassword(user.getPassword());
			}
			userRepo.save(currentUser.get());
			currentUser.get().setPassword("****");
			currentUser.get().setSecurityAnswer("****");
			currentUser.get().setSecurityQuestionId(0L);
			return currentUser.get();
		}else {
			throw new NoUserFound("No User Found with provided Details!!");
		}
	}

	@Override
	public User getUserById(String mailId) throws NoUserFound {
		Optional<User> user = userRepo.findById(mailId);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new NoUserFound("User Not Found with Id: " + mailId);
		}
	}

	@Override
	public boolean validateUserForChangePassword(String mailId, Long securityQuestion, String securityAnswer) throws NoUserFound {
		Optional<User> user = userRepo.findById(mailId);
		if(user.isPresent()) {
			if(user.get().getSecurityQuestionId() == securityQuestion && securityAnswer.equals(user.get().getSecurityAnswer())) {
				return true;
			}
			return false;
		}else {
			throw new NoUserFound("No User Found with Mail ID: " + mailId);
		}
	}

	@Override
	public boolean changePassword(String mailId, String password) throws NoUserFound {
		Optional<User> user = userRepo.findById(mailId);
		if(user.isPresent()) {
			user.get().setPassword(password);
			userRepo.save(user.get());
			return true;
		}else {
			throw new NoUserFound("No User Found with Mail ID: " + mailId);
		}
	}

	@Override
	public List<User> getAllUsers() throws NoUserFound {
		List<User> users = userRepo.findAll();
		if(users != null && users.size() > 0) {
			users = users.stream().map(t -> {
				t.setPassword("****");
				t.setSecurityQuestionId(0L);
				t.setSecurityAnswer("****");
				return t;
			}).collect(Collectors.toList());
			return users;
		}
		throw new NoUserFound("No User Registered yet!!");
	}

}
