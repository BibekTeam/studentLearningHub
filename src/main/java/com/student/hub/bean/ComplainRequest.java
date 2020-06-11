package com.student.hub.bean;

public class ComplainRequest {
	private String emailId;
	private String complainSubject;
	private String complainComments;

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

	@Override
	public String toString() {
		return "ComplainRequest [complainId=" + emailId + ", complaint =" + complainComments + "]";
	}

}
