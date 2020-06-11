package com.student.hub.bean;

public class Course {

	private int courseId;
	private String courseName;
	private String price;
	private String durationInDays;

	public Course() {
	}

	public Course(int courseId, String courseName, String price, String durationInDays) {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(String durationInDays) {
		this.durationInDays = durationInDays;
	}

}
