package com.stud.hub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	private String courseName;
	private int price;
	private String durationInDays;

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
		return "CourseDetails [courseId=" + courseId + ", courseName=" + courseName + ", price=" + price
				+ ", durationInDays=" + durationInDays + "]";
	}
}
