package com.stud.hub.service;

import java.util.List;

import com.student.hub.bean.ComplainRequest;
import com.student.hub.bean.Course;
import com.student.hub.bean.CourseCart;
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

	// Added for complain html method
	public void insertComplain(ComplainRequest request);

	// to return the comments that is typed in comment section of html
	public List<ComplainRequest> getComplain();

	public List<Course> getCourse();

	public int getRollNoByUserName(String userName);

	public void addToCart(CourseCart request);

	public List<CourseCart> getCart();

	public String getRoleByRollNo(int rollNo);

}
