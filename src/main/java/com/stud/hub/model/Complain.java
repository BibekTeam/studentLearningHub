package com.stud.hub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Complain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int complainId;
	@Column
	private String emailId;
	@Column
	private String complainSubject;
	@Column
	private String complainComments;

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getComplainSubject() {
		return complainSubject;
	}

	public void setComplainSubject(String complainSubject) {
		this.complainSubject = complainSubject;
	}

	public String getComplainComments() {
		return complainComments;
	}

	public void setComplainComments(String complainComments) {
		this.complainComments = complainComments;
	}

}