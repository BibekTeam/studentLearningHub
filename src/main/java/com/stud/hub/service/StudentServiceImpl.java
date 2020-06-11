package com.stud.hub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stud.hub.dao.StudentComplainDAOI;
import com.stud.hub.dao.StudentFeedbackDAOI;
import com.stud.hub.model.Complain;
import com.stud.hub.model.Feedback;
import com.student.hub.bean.ComplainRequest;
import com.student.hub.bean.Course;
import com.student.hub.bean.CourseCart;
import com.student.hub.bean.FeedBackRequest;
import com.student.hub.bean.SignInRequest;
import com.student.hub.bean.SignupRequest;
import com.student.hub.bean.StudentDetailsRequest;

@Service
public class StudentServiceImpl implements StudentServiceI {

	Map<Integer, SignupRequest> map = new HashMap<>();

	@Autowired
	private StudentFeedbackDAOI studentFeedbackDao;

	// Map<Integer, FeedBackRequest> feedBackMap = new HashMap<>();
	Map<Integer, Course> courseMap = new HashMap<>();
	//Map<String, ComplainRequest> complainMap = new HashMap<>();
	
	@Autowired
	private StudentComplainDAOI studentComplainDao;
	Map<Integer, CourseCart> courseCartMap = new HashMap<>();

	@Override
	public boolean signIn(SignInRequest request) {

		for (Map.Entry<Integer, SignupRequest> entry : map.entrySet()) {
			SignupRequest studentInfos = entry.getValue();
			if (request.getUsername().equals(studentInfos.getUsername())
					&& request.getPassword().equals(studentInfos.getPassword())) {
				return true;

			}

		}
		return false;
	}

	@Override
	public void insertComplain (ComplainRequest request) {
		Complain complain = new Complain();
		complain.setEmailId(request.getEmailId());
		complain.setComplainSubject(request.getComplainSubject());
		complain.setComplainComments(request.getComplainComments());
		studentComplainDao.save(complain);
	}

	@Override
	public void signUpForm(SignupRequest request) {
		map.put(request.getRollNo(), request);
	}

	@Override
	public void insertFeedBack(String username, FeedBackRequest request) {
		Feedback feedback = new Feedback();
		feedback.setUsername(username);
		feedback.setContent(request.getContent());
		studentFeedbackDao.save(feedback);

	}

	@Override
	public List<FeedBackRequest> getfeedback() {
		List<Feedback> feekList = studentFeedbackDao.findAll();
		List<FeedBackRequest> feedbackRequest = new ArrayList();
		for (Feedback feedback : feekList) {
			FeedBackRequest feedBackRequest = new FeedBackRequest();
			feedBackRequest.setContent(feedback.getContent());
			feedbackRequest.add(feedBackRequest);
		}

		return feedbackRequest;
	}

	@Override
	public List<Course> getCourse() {
		courseMap.put(1, new Course(1, "C", "200$", "45"));
		courseMap.put(2, new Course(2, "C++", "250$", "50"));
		courseMap.put(3, new Course(3, "Java", "500$", "60"));
		courseMap.put(4, new Course(4, "HTML", "300$", "30"));

		List<Course> request = new ArrayList<>(courseMap.values());
		return request;
	}

	@Override
	public List<ComplainRequest> getComplain() {
		List<Complain> complainList = studentComplainDao.findAll();
		List<ComplainRequest> complainRequestList = new ArrayList<ComplainRequest>();
		for (Complain complain : complainList) {
			ComplainRequest complainRequest = new ComplainRequest();
			complainRequest.setEmailId(complain.getEmailId());
			complainRequest.setComplainSubject(complain.getComplainSubject());
			complainRequest.setComplainComments(complain.getComplainComments());
			complainRequestList.add(complainRequest);
		}
		
		return complainRequestList;
	}


	@Override
	public SignupRequest studentDetails(StudentDetailsRequest request) {
		SignupRequest studentDtl = map.get(request.getRollNo());
		return studentDtl;
	}

	@Override
	public SignupRequest getUserProfile(int rollNo) {
		SignupRequest signUp = map.get(rollNo);
		if (map.containsKey(rollNo)) {
			return signUp;
		} else {
			return null;
		}
	}

	@Override
	public int getRollNoByUserName(String userName) {
		for (Map.Entry<Integer, SignupRequest> entry : map.entrySet()) {
			SignupRequest studentInfos = entry.getValue();
			if (userName.equals(studentInfos.getUsername())) {
				return studentInfos.getRollNo();
			}
		}
		return 0;
	}

	@Override
	public void addToCart(CourseCart request) {

		if (request.getCourseName().equals("C")) {
			request.setPrice(200);
			request.setCourseId(1);
			request.setDurationInDays("45");
		} else if (request.getCourseName().equals("C++")) {
			request.setPrice(250);
			request.setCourseId(2);
			request.setDurationInDays("50");
		} else if (request.getCourseName().equals("Java")) {
			request.setPrice(500);
			request.setCourseId(3);
			request.setDurationInDays("60");
		} else if (request.getCourseName().equals("HTML")) {
			request.setPrice(300);
			request.setCourseId(4);
			request.setDurationInDays("30");
		}

		courseCartMap.put(request.getCourseId(), request);

	}

	@Override
	public List<CourseCart> getCart() {
		List<CourseCart> cart = new ArrayList<>(courseCartMap.values());
		return cart;
	}

	@Override
	public String getRoleByRollNo(int rollNo) {
		return map.get(rollNo).getRole();
	}

}
