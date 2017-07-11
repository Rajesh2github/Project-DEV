package com.mvc.service;

import com.mvc.model.UserCredentials;

public interface LoginService {

	public boolean userAuthentication( UserCredentials userCredentials);
}
