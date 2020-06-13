package com.stud.hub.service;

import java.util.List;

import com.stud.hub.model.CourseCartDetails;
import com.stud.hub.model.CourseDetails;
import com.student.hub.bean.ComplainRequest;
import com.student.hub.bean.FeedBackRequest;
import com.student.hub.bean.SignInRequest;
import com.student.hub.bean.SignupRequest;
import com.student.hub.bean.StudentDetailsRequest;

public interface StudentServiceI {
	
	public boolean signIn(SignInRequest request);

	public void signUpForm(SignupRequest request);

	public SignupRequest getUserProfile(int rollNo);

	public SignupRequest studentDetails(StudentDetailsRequest request);

	public void insertFeedBack(String username, FeedBackRequest request);

	public List<FeedBackRequest> getfeedback();

	public void insertComplain(ComplainRequest request);

	public List<ComplainRequest> getComplain();

	public int getRollNoByUserName(String userName);

	public String getRoleByRollNo(int rollNo);

	public void insertCourse(CourseDetails course);

	public void addToCart(CourseCartDetails request);

	public List<CourseCartDetails> getCart();

	public List<CourseDetails> getCourse();

	public List<CourseCartDetails> getCartMap();

	public void addToCartMap(CourseCartDetails courseCart);

}
