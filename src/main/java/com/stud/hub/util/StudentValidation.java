package com.stud.hub.util;

import org.springframework.stereotype.Service;

import com.student.hub.bean.ComplainRequest;
import com.student.hub.bean.SignInRequest;

@Service
public class StudentValidation {

	public boolean signInReqValidation(SignInRequest request) {
		boolean flag = false;
		boolean isUsernameValid = StudentUtil.usernameValidation(request.getUsername());
		boolean isPasswordValid = StudentUtil.passwordValidation(request.getPassword());
		if (isUsernameValid && isPasswordValid) {
			flag = true;
		}

		return flag;
	}
	
	public boolean complainReqValidation(ComplainRequest request) {
		boolean flag = false;
		boolean isEmailValid = StudentUtil.emailValidation(request.getEmailId());
		if(isEmailValid) {
			flag=true;
		}
		return flag;
	}
	
}
