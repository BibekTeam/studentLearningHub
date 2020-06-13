package com.stud.hub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseCartDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	@Column
	private int courseId;
	@Column
	private String courseName;
	@Column
	private int price;
	@Column
	private String durationInDays;
	@Column
	private String courseBuyer;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public void setPrice(int price1) {
		this.price = price1;
	}

	public String getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(String durationInDays) {
		this.durationInDays = durationInDays;
	}

	public String getCourseBuyer() {
		return courseBuyer;
	}

	public void setCourseBuyer(String courseBuyer) {
		this.courseBuyer = courseBuyer;
	}

	@Override
	public String toString() {
		return "CourseCartDetails [cartId=" + cartId + ", courseId=" + courseId + ", courseName=" + courseName
				+ ", price=" + price + ", durationInDays=" + durationInDays + ", courseBuyer=" + courseBuyer + "]";
	}

}
