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

}
