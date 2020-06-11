package com.stud.hub.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stud.hub.service.StudentServiceI;
import com.student.hub.bean.ComplainRequest;
import com.student.hub.bean.Course;
import com.student.hub.bean.CourseCart;
import com.student.hub.bean.FeedBackRequest;
import com.student.hub.bean.SignInRequest;
import com.student.hub.bean.SignupRequest;
import com.student.hub.bean.StudentDetailsRequest;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceI studentService;

	@RequestMapping("/index")
	public String index() {
		return "index.html";
	}

	@RequestMapping("/signInPage")
	public String signInForm(SignInRequest request) {
		return "SignIn.html";
	}

	// method to return complain page
	@RequestMapping("/complainBoxPage")
	public String complainPage(ComplainRequest request, Model model) {
		return "complainBox";
	}

	@RequestMapping("/insertComplainBox")
	public String insertComplain(ComplainRequest request, Model model) {
		studentService.insertComplain(request);
		return "redirect:viewComplains ";
	}

	@RequestMapping("/viewComplains")
	public String viewComplains(Model model) {
		List<ComplainRequest> complain = studentService.getComplain();
		model.addAttribute("complainData", complain);
		return "viewComplains.html";
	}

	@RequestMapping("/signUpPage")
	public String signUpForm(SignInRequest request) {
		return "signUp.html";
	}

	@RequestMapping("/signInForm")
	public String signIn(SignInRequest request, HttpSession session, Model model) {
		boolean isFound = studentService.signIn(request);
		if (isFound) {
			int rollNo = studentService.getRollNoByUserName(request.getUsername());
			String role = studentService.getRoleByRollNo(rollNo);
			session.setAttribute("username", request.getUsername());
			session.setAttribute("rollNo", rollNo);
			session.setAttribute("role", role);
			String name = (String) session.getAttribute("username");
			model.addAttribute("username", name);
			if (role.equals("Student")) {
				return "userHome";
			} else if (role.equals("Admin")) {
				return "adminhomepage";
			}
		}
		return "error";
	}

	@RequestMapping("/feedBackForm")
	public String feedbackForm(FeedBackRequest request, Model model, HttpSession session) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		studentService.insertFeedBack(name, request);
		List<FeedBackRequest> feedback = studentService.getfeedback();
		model.addAttribute("feedback", feedback);
		return "feedBack.html";
	}

	@RequestMapping("/getStudentDetailsPage")
	public String getStudentDetailsPage(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "studentDetail";
	}

	@RequestMapping("/studentDetails")
	public String studentDetails(StudentDetailsRequest request, Model model, HttpSession session) {
		SignupRequest studentDetails = studentService.studentDetails(request);
		model.addAttribute("studentData", studentDetails);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "studentDetails.html";
	}

	@RequestMapping("/signUpForm")
	public String signUp(SignupRequest request) {
		studentService.signUpForm(request);
		return "SignIn.html";
	}

	@RequestMapping(value = "/getProfile")
	public String viewProfile(Model model, HttpSession session) {
		int rollNo = (int) session.getAttribute("rollNo");
		SignupRequest responseData = studentService.getUserProfile(rollNo);
		model.addAttribute("data", responseData);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "profile";
	}

	@RequestMapping(value = "/getCourses")
	public String viewCourses(Model model, HttpSession session) {
		List<Course> listOfCourse = studentService.getCourse();
		model.addAttribute("courseData", listOfCourse);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "viewCourse.html";
	}

	@RequestMapping("/viewCourse")
	public String viewCoursePage(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "redirect:getCourses";
	}

	@RequestMapping("/myProfile")
	public String myProfilePage(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "redirect:getProfile";
	}

	@RequestMapping(value = "/orderCourse")
	public String courseCart(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "cartView";
	}

	@RequestMapping(value = "/paymentPage")
	public String addCourseCart(CourseCart request, HttpSession session, Model model) {
		studentService.addToCart(request);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "redirect:viewPayment";
	}

	@RequestMapping("/viewPayment")
	public String viewCourseCart(HttpSession session, Model model) {

		List<CourseCart> cart = studentService.getCart();

		model.addAttribute("cartData", cart);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "paymentPage";
	}

	@RequestMapping(value = "/sucessPage")
	public String sucessPage(HttpSession session, Model model, String price) {
		String name = (String) session.getAttribute("username");
		String amount = (String) session.getAttribute(price);
		model.addAttribute("amount", amount);
		model.addAttribute("username", name);
		return "sucess";
	}

	@RequestMapping("/homePage")
	public String homePage(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		String role = (String) session.getAttribute("role");
		if (role.equals("Student")) {
			return "userHome.html";
		}
		else if (role.equals("Admin")) {
			return "adminhomepage";
		} else {
			return "error.html";
		}

	}

}
