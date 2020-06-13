package com.stud.hub.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stud.hub.model.CourseCartDetails;
import com.stud.hub.model.CourseDetails;
import com.stud.hub.service.StudentServiceI;
import com.stud.hub.util.StudentUtil;
import com.stud.hub.util.StudentValidation;
import com.student.hub.bean.ComplainRequest;
import com.student.hub.bean.FeedBackRequest;
import com.student.hub.bean.SignInRequest;
import com.student.hub.bean.SignupRequest;
import com.student.hub.bean.StudentDetailsRequest;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceI studentService;

	@Autowired
	private StudentValidation studentValidation;

	@RequestMapping("/index")
	public String index() {
		return "indextrial";
	}

	@RequestMapping("/signInPage")
	public String signInForm(SignInRequest request) {
		return "indextrial";
	}

	@RequestMapping("/complainBoxPage")
	public String complainPage(ComplainRequest request, Model model) {
		return "complainBox";
	}

	@RequestMapping("/insertComplainBox")
	public String insertComplain(ComplainRequest request, Model model) {
		if (studentValidation.complainReqValidation(request)) {
			studentService.insertComplain(request);
			return "redirect:viewComplains ";
		}
		return "error";
	}

	@RequestMapping("/viewComplains")
	public String viewComplains(Model model) {
		List<ComplainRequest> complain = studentService.getComplain();
		model.addAttribute("complainData", complain);
		return "viewComplains";
	}

	@RequestMapping("/signUpPage")
	public String signUpForm(SignInRequest request) {

		return "indextrial";
	}

	@RequestMapping("/signInForm")
	public String signIn(SignInRequest request, HttpSession session, Model model) {
		if (studentValidation.signInReqValidation(request)) {
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
		}
		return "error";
	}

	@RequestMapping("/feedBackForm")
	public String feedbackForm(FeedBackRequest request, Model model, HttpSession session) {
		if (StudentUtil.contentValidation(request.getContent())) {
			String name = (String) session.getAttribute("username");
			model.addAttribute("username", name);
			studentService.insertFeedBack(name, request);
			List<FeedBackRequest> feedback = studentService.getfeedback();
			model.addAttribute("feedback", feedback);
			return "feedBack";
		}
		return "error";
	}

	@RequestMapping("/getStudentDetailsPage")
	public String getStudentDetailsPage(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "studentDetails";
	}

	@RequestMapping("/studentDetails")
	public String studentDetails(StudentDetailsRequest request, Model model, HttpSession session) {
		SignupRequest studentDetails = studentService.studentDetails(request);
		model.addAttribute("studentData", studentDetails);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "studentDetails";
	}

	@RequestMapping("/signUpForm")
	public String signUp(SignupRequest request) {
		studentService.signUpForm(request);
		return "indextrial";
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

	@RequestMapping("/myProfile")
	public String myProfilePage(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "redirect:getProfile";
	}

	@RequestMapping("/homePage")
	public String homePage(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		String role = (String) session.getAttribute("role");
		if (role.equals("Student")) {
			return "userHome.html";
		} else if (role.equals("Admin")) {
			return "adminhomepage";
		} else {
			return "error";
		}

	}

	@RequestMapping("/addCourseView")
	public String addCourseView(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		String role = (String) session.getAttribute("role");
		if (role.equals("Admin")) {

			return "addCourse";
		} else {
			return "error";
		}
	}

	@RequestMapping("/addCourse")
	public String addCourse(CourseDetails course, HttpSession session) {

		studentService.insertCourse(course);
		return "redirect:getCourses";
	}

	@RequestMapping(value = "/getCourses")
	public String viewCourses(Model model, HttpSession session) {
		List<CourseDetails> listOfCourse = studentService.getCourse();
		model.addAttribute("courseData", listOfCourse);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "viewCourse";
	}

	@RequestMapping("/viewCourse")
	public String viewCoursePage(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "redirect:getCourses";
	}

	@RequestMapping(value = "/orderCourse")
	public String courseCart(HttpSession session, Model model) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		List<CourseDetails> details = studentService.getCourse();
		model.addAttribute("courseDetailData", details);
		return "cartView";
	}

	@RequestMapping(value = "/paymentPage")
	public String addCourseCart(CourseCartDetails request, HttpSession session, Model model,
			CourseCartDetails courseCart) {
		studentService.addToCart(request);
		studentService.addToCartMap(courseCart);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "redirect:viewPayment";
	}

	@RequestMapping("/viewPayment")
	public String viewCourseCart(CourseCartDetails request, HttpSession session, Model model) {
		List<CourseCartDetails> course = studentService.getCartMap();
		model.addAttribute("cartData", course);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "paymentPage";
	}

	@RequestMapping(value = "/sucessPage")
	public String sucessPage(HttpSession session, Model model, String price) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		return "sucess";
	}

	@RequestMapping(value = "/orderViewPage")
	public String orderPage(HttpSession session, Model model, String price) {
		List<CourseCartDetails> cart = studentService.getCart();
		model.addAttribute("cartorderData", cart);
		String name = (String) session.getAttribute("username");
		model.addAttribute("username", name);
		String role = (String) session.getAttribute("role");
		if (role.equals("Admin")) {

			return "cartOrderView";
		} else {
			return "error";
		}

	}

}
