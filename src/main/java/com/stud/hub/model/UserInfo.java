package com.stud.hub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInfo {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int rollNo;
	 @Column
	 private String name;
	 @Column
	 private int age;
	 @Column
	 private String address;
	 @Column
	 private String contactNum;
	 @Column
	 private String username;
	 @Column
	 private String password;
	 @Column
	 private String role;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserInfo [rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", contactNum=" + contactNum + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
	 
	 
}
