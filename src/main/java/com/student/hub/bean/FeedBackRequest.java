package com.student.hub.bean;

public class FeedBackRequest {
	private int feedbackId;
	private String content;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "FeedBackRequest [feedbackId=" + feedbackId + ", content=" + content + "]";
	}

}
