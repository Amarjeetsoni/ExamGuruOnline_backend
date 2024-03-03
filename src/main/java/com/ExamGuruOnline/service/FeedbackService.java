package com.ExamGuruOnline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamGuruOnline.entity.Feedback;
import com.ExamGuruOnline.repository.FeedbackRepo;
import com.ExamGuruOnline.serviceInterface.FeedbackServiceInterface;

@Service
public class FeedbackService implements FeedbackServiceInterface{

	@Autowired
	private FeedbackRepo feedbackRepo;

	@Override
	public boolean addFeedbackToTest(String comment, String userId, Long testId) {
		Feedback fb = new Feedback(comment, userId, testId);
		feedbackRepo.save(fb);
		return true;
	}

	@Override
	public boolean addFeedbackToQuestion(String comment, String userId, Long questionId) {
		Feedback fb = new Feedback(comment, userId, questionId);
		feedbackRepo.save(fb);
		return true;
	}

	@Override
	public Feedback getFeedbackById(Long id) throws Exception {
		Optional<Feedback> fb = feedbackRepo.findById(id);
		if(fb.isPresent()) {
			return fb.get();
		}else {
			throw new Exception("No Feedback Present with the passed Id.");
		}
	}

	@Override
	public List<Feedback> getFeedbackOfListOfIds(List<Long> ids) {
		List<Feedback> listFB = new ArrayList<>();
		for(int i = 0; i < ids.size(); i++) {
			Optional<Feedback> fb = feedbackRepo.findById(ids.get(0));
			if(fb.isPresent()) {
				listFB.add(fb.get());
			}
		}
		return listFB;
	}

	@Override
	public List<Feedback> getAllFeedbackWithUserId(String userId) {
		List<Feedback> list = feedbackRepo.findByUserId(userId);
		return list;
	}

	@Override
	public List<Feedback> getAllFeedbackByQuestionOrTestId(Long testId) throws Exception {
		try {
			return feedbackRepo.findByQuesTestId(testId);
		}catch(Exception ex) {
			throw new Exception("No Feedback is provided on given Test/Question.");
		}
	}
	
}
