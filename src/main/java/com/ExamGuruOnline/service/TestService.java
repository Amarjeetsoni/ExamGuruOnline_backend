package com.ExamGuruOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamGuruOnline.customeException.TestRelatedException;
import com.ExamGuruOnline.entity.Category;
import com.ExamGuruOnline.entity.OrganizationDetails;
import com.ExamGuruOnline.entity.Test;
import com.ExamGuruOnline.repository.CategoryRepo;
import com.ExamGuruOnline.repository.OrganizationDetailsRepo;
import com.ExamGuruOnline.repository.TestRepo;
import com.ExamGuruOnline.serviceInterface.TestServiceInterface;

@Service
public class TestService implements TestServiceInterface{

	@Autowired
	private TestRepo testRepo;
	
	@Autowired
	private CategoryRepo catRepo;
	
	@Autowired
	private OrganizationDetailsRepo orgRepo;
	
	@Override
	public boolean addNewTest(Test test) throws TestRelatedException {
		try {
			Optional<Category> cat = catRepo.findById(test.getTestCategoryId());
			if(!cat.isPresent()) {
				throw new TestRelatedException("No Such Categrory Details found with the provided category Id. Please validate again!!");
			}
			Optional<OrganizationDetails> org = orgRepo.findById(test.getOrganizationId());
			if(!org.isPresent()) {
				throw new TestRelatedException("No Such Organization Details found with the provided detail. Please validate again!!");
			}
			testRepo.save(test);
			return true;
		}catch(Exception ex) {
			throw new TestRelatedException("There is some issue while saving Test Details.");
		}
	}

	@Override
	public boolean updateTestDetails(Test test, String currentUserID) throws TestRelatedException {
		try {
			Optional<Test> currentTest = testRepo.findById(test.getTestId());
			if(!currentTest.isPresent()) {
				throw new Exception("No test Details found with the test Id Provided, Please chech and try again!!");
			}
			if(!currentTest.get().getUserId().equals(currentUserID)) {
				throw new Exception("You are not authorized to Update current Test Details, Please check with authorized user to update!!");
			}
			currentTest.get().setTotalMarks(test.getTotalMarks());
			currentTest.get().setQuestionId(test.getQuestionId());
			currentTest.get().setTestCategoryId(test.getTestCategoryId());
			currentTest.get().setTestDuration(test.getTestDuration());
			currentTest.get().setTestName(test.getTestName());
			testRepo.save(currentTest.get());
			return true;
		}catch(Exception ex) {
			throw new TestRelatedException(ex.getLocalizedMessage());
		}
	}

	@Override
	public boolean deleteTestById(Long testId, String currentUserId) throws TestRelatedException {
		try {
			Optional<Test> test = testRepo.findById(testId);
			if(!test.isPresent()) {
				throw new Exception("No Test Details Found with the testId Provided, Please try again!!");
			}
			if(!test.get().getUserId().equals(currentUserId)) {
				throw new Exception("You are not authorized to Update current Test Details, Please check with authorized user to update!!");
			}
			testRepo.deleteById(testId);
			return true;
		}catch(Exception ex) {
			throw new TestRelatedException(ex.getLocalizedMessage());
		}
	}

	@Override
	public Test getTestById(Long id) throws TestRelatedException {
		try {
			Optional<Test> test = testRepo.findById(id);
			if(!test.isPresent()) {
				throw new Exception("No Test Detail found with the ID : " + id);
			}
			return test.get();
		}catch(Exception ex) {
			throw new TestRelatedException(ex.getMessage());
		}
	}

	@Override
	public boolean activateTestById(Long id , String currentUser) throws TestRelatedException {
		try {
			Optional<Test> test = testRepo.findById(id);
			if(!test.isPresent()) {
				throw new Exception("No Test Detail found with the ID : " + id);
			}
			if(!test.get().getUserId().equals(currentUser)) {
				throw new Exception("You are not authorized to Activate test, Please check with the test Owner!");
			}
			if(test.get().isActive()) {
				throw new Exception("Test is Already Active !!");
			}
			test.get().setActive(true);
			testRepo.save(test.get());
			return true;
		}catch(Exception ex) {
			throw new TestRelatedException(ex.getMessage());
		}
	}
	
	@Override
	public boolean deActivateTestById(Long id , String currentUser) throws TestRelatedException {
		try {
			Optional<Test> test = testRepo.findById(id);
			if(!test.isPresent()) {
				throw new Exception("No Test Detail found with the ID : " + id);
			}
			if(!test.get().getUserId().equals(currentUser)) {
				throw new Exception("You are not authorized to Activate test, Please check with the test Owner!");
			}
			if(!test.get().isActive()) {
				throw new Exception("Test is Already DeActivated !!");
			}
			test.get().setActive(false);
			testRepo.save(test.get());
			return true;
		}catch(Exception ex) {
			throw new TestRelatedException(ex.getMessage());
		}
	}


	@Override
	public boolean addFeedbackToTest(Long feedbackId, Long testId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Test> getTestByOrganizationID(Long OrgId) throws TestRelatedException {
		try {
			List<Test> test = testRepo.findByOrganizationId(OrgId);
			if(test == null || test.size() == 0) {
				throw new TestRelatedException("No test Registered by your Organization yet! Please proceed to add new.");
			}
			return test;
		}catch(Exception exp) {
			throw new TestRelatedException("Something wents wrong while fetching the test Details, Please try again!!");
		}
	}

	@Override
	public List<Test> getTestByUserID(String userName) throws TestRelatedException {
		try {
			List<Test> test = testRepo.findByUserId(userName);
			if(test == null || test.size() == 0) {
				throw new TestRelatedException("No test Registered by you yet! Please proceed to add new.");
			}
			return test;
		}catch(Exception exp) {
			throw new TestRelatedException("Something wents wrong while fetching the test Details, Please try again!!");
		}
	}

}
