package com.stud.hub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stud.hub.dao.CourseCartDetailsDAOI;
import com.stud.hub.dao.StudentComplainDAOI;
import com.stud.hub.dao.StudentCourseDAOI;
import com.stud.hub.dao.StudentFeedbackDAOI;
import com.stud.hub.dao.StudentUserInfoDAOI;
import com.stud.hub.model.Complain;
import com.stud.hub.model.CourseCartDetails;
import com.stud.hub.model.CourseDetails;
import com.stud.hub.model.Feedback;
import com.stud.hub.model.UserInfo;
import com.student.hub.bean.ComplainRequest;
import com.student.hub.bean.CourseCart;
import com.student.hub.bean.FeedBackRequest;
import com.student.hub.bean.SignInRequest;
import com.student.hub.bean.SignupRequest;
import com.student.hub.bean.StudentDetailsRequest;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	StudentUserInfoDAOI userInfoDao;

	@Autowired
	private StudentFeedbackDAOI studentFeedbackDao;

	Map<Integer, CourseCartDetails> courseCartDetailsMap = new HashMap<>();

	@Autowired
	private StudentCourseDAOI courseDao;

	@Autowired
	private CourseCartDetailsDAOI courseCartDetailsDao;

	@Autowired
	private StudentComplainDAOI studentComplainDao;

	Map<Integer, CourseCart> courseCartMap = new HashMap<>();

	@Override
	public void insertComplain(ComplainRequest request) {
		Complain complain = new Complain();
		complain.setEmailId(request.getEmailId());
		complain.setComplainSubject(request.getComplainSubject());
		complain.setComplainComments(request.getComplainComments());
		studentComplainDao.save(complain);
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
		List<FeedBackRequest> feedbackRequest = new ArrayList<FeedBackRequest>();
		for (Feedback feedback : feekList) {
			FeedBackRequest feedBackRequest = new FeedBackRequest();
			feedBackRequest.setContent(feedback.getContent());
			feedbackRequest.add(feedBackRequest);
		}

		return feedbackRequest;
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
	public List<CourseDetails> getCourse() {

		return courseDao.findAll();
	}

	@Override
	public void insertCourse(CourseDetails course) {
		courseDao.save(course);
	}

	@Override
	public void addToCart(CourseCartDetails courseCart) {
		if (courseCart.getCourseName().equals("C")) {
			courseCart.setPrice(200);
			courseCart.setCourseId(101);
			courseCart.setDurationInDays("45");
		} else if (courseCart.getCourseName().equals("C++")) {
			courseCart.setPrice(250);
			courseCart.setCourseId(102);
			courseCart.setDurationInDays("50");
		} else if (courseCart.getCourseName().equals("Java")) {
			courseCart.setPrice(500);
			courseCart.setCourseId(103);
			courseCart.setDurationInDays("60");
		} else if (courseCart.getCourseName().equals("HTML")) {
			courseCart.setPrice(300);
			courseCart.setCourseId(104);
			courseCart.setDurationInDays("30");
		}
		courseCartDetailsDao.save(courseCart);
	}

	@Override
	public void addToCartMap(CourseCartDetails courseCart) {
		if (courseCart.getCourseName().equals("C")) {
			courseCart.setPrice(200);
			courseCart.setCourseId(101);
			courseCart.setDurationInDays("45");
		} else if (courseCart.getCourseName().equals("C++")) {
			courseCart.setPrice(250);
			courseCart.setCourseId(102);
			courseCart.setDurationInDays("50");
		} else if (courseCart.getCourseName().equals("Java")) {
			courseCart.setPrice(500);
			courseCart.setCourseId(103);
			courseCart.setDurationInDays("60");
		} else if (courseCart.getCourseName().equals("HTML")) {
			courseCart.setPrice(300);
			courseCart.setCourseId(104);
			courseCart.setDurationInDays("30");
		}
		courseCartDetailsMap.put(courseCart.getCartId(), courseCart);
	}

	@Override
	public List<CourseCartDetails> getCartMap() {
		List<CourseCartDetails> courseCartPage = new ArrayList<CourseCartDetails>(courseCartDetailsMap.values());

		return courseCartPage;
	}

	@Override
	public List<CourseCartDetails> getCart() {

		return courseCartDetailsDao.findAll();
	}

	@Override
	public boolean signIn(SignInRequest request) {
		UserInfo userInfo = userInfoDao.findByUsername(request.getUsername());
		if (userInfo.getUsername().equals(request.getUsername())
				&& userInfo.getPassword().equals(request.getPassword())) {
			return true;
		}

		return false;
	}

	@Override
	public void signUpForm(SignupRequest request) {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(request.getName());
		userInfo.setAge(request.getAge());
		userInfo.setAddress(request.getAddress());
		userInfo.setContactNum(request.getContactNum());
		userInfo.setUsername(request.getUsername());
		userInfo.setPassword(request.getPassword());
		userInfo.setRole(request.getRole());

		userInfoDao.save(userInfo);
	}

	@Override
	public SignupRequest studentDetails(StudentDetailsRequest request) {
		SignupRequest studentDtl = new SignupRequest();
		UserInfo userInfo = userInfoDao.findById(request.getRollNo()).get();
		studentDtl.setName(userInfo.getName());
		studentDtl.setAge(userInfo.getAge());
		studentDtl.setAddress(userInfo.getAddress());
		studentDtl.setContactNum(userInfo.getContactNum());
		studentDtl.setUsername(userInfo.getUsername());
		studentDtl.setPassword(userInfo.getPassword());
		studentDtl.setRole(userInfo.getRole());

		return studentDtl;
	}

	@Override
	public SignupRequest getUserProfile(int rollNo) {
		StudentDetailsRequest request = new StudentDetailsRequest();
		request.setRollNo(rollNo);
		SignupRequest studentDtl = studentDetails(request);

		return studentDtl;
	}

	@Override
	public int getRollNoByUserName(String userName) {
		UserInfo userInfo = userInfoDao.findByUsername(userName);

		return userInfo.getRollNo();
	}

	@Override
	public String getRoleByRollNo(int rollNo) {
		UserInfo userInfo = userInfoDao.findById(rollNo).get();
		return userInfo.getRole();

	}
}
