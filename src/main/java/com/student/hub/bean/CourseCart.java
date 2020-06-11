package com.student.hub.bean;

public class CourseCart {

	private int courseId;
	private String courseName;
	private int price;
	private String durationInDays;
	public CourseCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseCart(int courseId, String courseName, int price, String durationInDays) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.price = price;
		this.durationInDays = durationInDays;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDurationInDays() {
		return durationInDays;
	}
	public void setDurationInDays(String durationInDays) {
		this.durationInDays = durationInDays;
	}
	@Override
	public String toString() {
		return "CourseCart [courseId=" + courseId + ", courseName=" + courseName + ", price=" + price
				+ ", durationInDays=" + durationInDays + "]";
	}
	
	
	
}
