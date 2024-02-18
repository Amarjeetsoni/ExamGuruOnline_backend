package com.ExamGuruOnline.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ExamGuruOnline.entity.SecurityQuestion;
import com.ExamGuruOnline.entity.User;
import com.ExamGuruOnline.repository.SecurityQuestionRepo;
import com.ExamGuruOnline.serviceInterface.UserServiceInterface;

@Component
public class LoadSecurityQuestion implements CommandLineRunner {

	@Autowired
	private SecurityQuestionRepo repo;
	
	@Autowired
	private UserServiceInterface userService;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new SecurityQuestion("What is your pet Name ?"));
		repo.save(new SecurityQuestion("What is place of your birth ?"));
		repo.save(new SecurityQuestion("What is your favorite food item ?"));
		repo.save(new SecurityQuestion("What is the name of your favorute teacher ?"));
		repo.save(new SecurityQuestion("Want to write some random thing ?"));
		try {
			User user = new User("GovernanceGuru", "Admin", "adminmaster@examguru.com", "MyPassword@1234", 0L, 0L, "answer");
			userService.addNewUser(user);
		}catch(Exception ex) {
			System.out.println("Something wents wrong");
		}
	}
	
	
}
