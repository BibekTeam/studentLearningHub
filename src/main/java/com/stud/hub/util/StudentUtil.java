package com.stud.hub.util;

public class StudentUtil {

	public static boolean usernameValidation(String username) {
		if ((username.length() > 6) && (username.matches(".*[1-9]+.") && (username.matches(".*[a-z]+.")))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean passwordValidation(String password) {
		if ((password.length() > 8) && (password.matches(".*[1-9]+.") && (password.matches(".*[a-z]+.")))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean emailValidation(String email) {
		if (email.matches(".*[^(.+)@(.+)$]+.")) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean subjectValidation(String subject) {
		boolean flag = false;
		String[] str = subject.split(" ");
		if (str.length >= 4) {
			flag = true;
		}
		return flag;
	}

	public static boolean contentValidation(String content) {
		boolean flag = false;
		if (content.length() >= 100) {
			flag = true;
		}
		return flag;
	}

}
